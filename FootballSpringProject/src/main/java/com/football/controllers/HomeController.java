package com.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("message", "Football Spring");
		return "index";
	}
	
	@GetMapping("/redirectToTeams")
    public RedirectView redirectToTeams(
      RedirectAttributes attributes) {
//        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
//        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("teams");
    }
	
	@GetMapping("/redirectToUsers")
    public RedirectView redirectToUsers(
      RedirectAttributes attributes) {
//        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
//        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("users");
    }
}
