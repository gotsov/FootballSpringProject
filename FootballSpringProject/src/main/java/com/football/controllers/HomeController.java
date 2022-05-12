package com.football.controllers;

import java.security.Principal;

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
	
//	@GetMapping("/")
//    String index(Principal principal) {
//        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//    }
	
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
        return new RedirectView("users");
    }
	
	@GetMapping("/redirectToLogin")
    public RedirectView redirectToLogin(
      RedirectAttributes attributes) {
        return new RedirectView("login");
    }
}
