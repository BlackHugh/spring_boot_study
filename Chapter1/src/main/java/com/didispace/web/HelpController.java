package com.didispace.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpController {

	@RequestMapping("/help")
	public String index(){
		return "SOS";
	}
	
}
