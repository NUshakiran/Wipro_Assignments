package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ApplicationController {
	
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}
	
	@GetMapping("/education")
	public String showEducation() {
		return "education";
	}
	
	@GetMapping("/skills")
	
	public String showSkills() {
		return "Skills";
	}
	
	@GetMapping("/contact")
	
	public String getContact() {
		return "Contact";
	}

}
