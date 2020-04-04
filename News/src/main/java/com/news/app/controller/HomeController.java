package com.news.app.controller;

import java.io.IOException;
import java.lang.String;
import java.text.ParseException;
import java.util.List;

import com.news.app.model.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home() {
		return "home";
    }	
}