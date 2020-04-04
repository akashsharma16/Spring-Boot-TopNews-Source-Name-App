package com.news.app.controller;

import java.io.IOException;
import java.lang.String;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.news.app.model.Source;
import com.news.app.model.form;
import com.news.app.service.NewsService;

@RestController
public class NewsController {
	

	@GetMapping(value = "/country_code={country}/category={category}/{k}")
	public List<Source> both(@PathVariable String country,@PathVariable String category,@PathVariable Integer k) throws ParseException, IOException {
		List<Source> sources=NewsService.CountryandCategory(country,category,k);
		return sources;
	} 
	
	/*@PostMapping(value = "/posts")
    public List<Source> get(@ModelAttribute("input") form input) throws ParseException, IOException {

		form f=new form();
		f.setcountry(input.country);
		String country = f.getcountry();
		System.out.println(country);
		String category = input.getcategory();
		System.out.println(category);
		Integer k = input.getk();

		List<Source> sources=NewsService.CountryandCategory(country,category,k);
		return sources;
    }*/

	@GetMapping(value = "/country_code={country}/{k}")
	public List<Source> country(@PathVariable String country,@PathVariable Integer k) throws ParseException, IOException {
		return NewsService.Country(country,k);
	}

	@GetMapping(value = "/category={category}/{k}")
	public List<Source> category(@PathVariable String category,@PathVariable Integer k) throws ParseException, IOException {
		return NewsService.Category(category,k);
	}

	
}
