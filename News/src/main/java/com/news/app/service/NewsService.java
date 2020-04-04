package com.news.app.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.lang.String;
import com.news.app.model.Source;

import java.net.Proxy;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;


@Service
public class NewsService extends MappingJackson2HttpMessageConverter {

	private static NewsService ourInstance = new NewsService();
	
	 public static NewsService getInstance() {
	        return ourInstance;
	    }
	 
	    private NewsService() {
	    	setPrettyPrint(true);
	    }
	
	    
	    public static List<Source> CountryandCategory(String country,String category, Integer k) throws IOException {
			
	    	String urlString = "http://newsapi.org/v2/top-headlines?country="+country+"&category="+category+"&apiKey=a24d98f562554d239d33c2f9d3da0983";
			
			SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.2.30", 8080));
			clientHttpReq.setProxy(proxy);

			RestTemplate restTemplate = new RestTemplate(clientHttpReq);
	    	    String result = restTemplate.getForObject(urlString, String.class); 	
	    	    JSONObject root = new JSONObject(result);   
	    	 
	    		String statusObject = "";
	            Integer totalResults = 0;
	            
	            String name = "";              
	            Integer c=0;
				List<Source> sourceList = new ArrayList<>();

				HashSet<String> h = new HashSet<String>();
				statusObject =  root.getString("status");
				totalResults =  root.getInt("totalResults");
				
				 JSONArray articlesObject = root.getJSONArray("articles");

			        for(int i = 0; i < articlesObject.length(); i++) {
			              	
			            JSONObject arrayElement = articlesObject.getJSONObject(i);
			           
			            JSONObject sourceother = arrayElement.getJSONObject("source");
						
						
						name =  sourceother.getString("name");
						if(!h.contains(name))
						{
							Source source = new Source();
							source.setName(name);
							source.setId(c+1);
							sourceList.add(source);
							h.add(name);	          
							c++;
						}
						if(c==k)
						break;
			            
	    }    
			        return sourceList;
	    	
}

		public static List<Source> Country(String country, Integer k) throws IOException {
			
	String urlString = "http://newsapi.org/v2/top-headlines?country="+country+"&apiKey=a24d98f562554d239d33c2f9d3da0983";
	
	SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.2.30", 8080));
	clientHttpReq.setProxy(proxy);

	RestTemplate restTemplate = new RestTemplate(clientHttpReq);
		String result = restTemplate.getForObject(urlString, String.class); 	
		JSONObject root = new JSONObject(result);   
	 
		String statusObject = "";
		Integer totalResults = 0;
		
		String name = "";              
		Integer c=0;
		List<Source> sourceList = new ArrayList<>();

		HashSet<String> h = new HashSet<String>();
		statusObject =  root.getString("status");
		totalResults =  root.getInt("totalResults");
		
		 JSONArray articlesObject = root.getJSONArray("articles");

			for(int i = 0; i < articlesObject.length(); i++) {
					  
				JSONObject arrayElement = articlesObject.getJSONObject(i);
			   
				JSONObject sourceother = arrayElement.getJSONObject("source");
				
				
				name =  sourceother.getString("name");
				if(!h.contains(name))
				{
					Source source = new Source();
					source.setName(name);
					source.setId(c+1);
					sourceList.add(source);
					h.add(name);	          
					c++;
				}
				if(c==k)
				break;
				
}    
			return sourceList;
	
}
	
		public static List<Source> Category(String category, Integer k) throws IOException {
			
	String urlString = "http://newsapi.org/v2/top-headlines?category="+category+"&apiKey=a24d98f562554d239d33c2f9d3da0983";
	
	SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.2.30", 8080));
	clientHttpReq.setProxy(proxy);

	RestTemplate restTemplate = new RestTemplate(clientHttpReq);
		String result = restTemplate.getForObject(urlString, String.class); 	
		JSONObject root = new JSONObject(result);   
	 
		String statusObject = "";
		Integer totalResults = 0;
		
		String name = "";              
		Integer c=0;
		List<Source> sourceList = new ArrayList<>();

		HashSet<String> h = new HashSet<String>();
		statusObject =  root.getString("status");
		totalResults =  root.getInt("totalResults");
		
		 JSONArray articlesObject = root.getJSONArray("articles");

			for(int i = 0; i < articlesObject.length(); i++) {
					  
				JSONObject arrayElement = articlesObject.getJSONObject(i);
			   
				JSONObject sourceother = arrayElement.getJSONObject("source");
				
				
				name =  sourceother.getString("name");
				if(!h.contains(name))
				{
					Source source = new Source();
					source.setName(name);
					source.setId(c+1);
					sourceList.add(source);
					h.add(name);	          
					c++;
				}
				if(c==k)
				break;
				
}    
			return sourceList;
	
}

	    
}