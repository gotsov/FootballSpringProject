package com.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String getHomePage(Model model) {
		model.addAttribute("message", "Football Spring");
		return "index";
	}
}
