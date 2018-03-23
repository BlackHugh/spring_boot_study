package com.example.Chapter1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController	//setting as RestController will not return page. it always return a json string.
@Controller		//use Controller can make string return a page. this way if you want to return a json result, you should add @ResponseBody
public class HelloController {

	@RequestMapping("/")
	public String index(ModelMap map){
		map.addAttribute("host", "http://blog.didispace.com");
		return "index";
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String getHelloWorld(){
		return "hello world";
	}
}
