package com.example.Chapter1;

import com.didispace.web.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackageClasses=com.didispace.web.HelpController.class)
@ComponentScan(basePackages="com.didispace.web.*")
//@ComponentScan(basePackages="com.example.Chapter1.*")
public class Chapter1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
}
