package com.psv.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {

	@RequestMapping("/")
	public String showHomePage()
	{
		return "Home.html";
		
	}
}
