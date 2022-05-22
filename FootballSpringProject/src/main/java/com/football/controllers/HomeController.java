package com.football.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.football.models.Team;
import com.football.models.User;
import com.football.services.UsersService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UsersService userService;
	private User loggedUser = new User();
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		if(loggedUser != null) {
			model.addAttribute("user", loggedUser);
		}
		else {
			model.addAttribute("isUserLogged", true);
		}
		
		return "index";
	}
	
	@GetMapping("/registerUser")
	public String getRegisterUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registerUser";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		loggedUser = user;
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/validateLogin")
	public String validateLogin(@ModelAttribute("user") User user, Model model) {
		
		if(userService.userExists(user)) {
			loggedUser = userService.getUserByUsername(user.getUsername());
			
			model.addAttribute("user" , loggedUser);
			return "redirect:/";
		}
		else
			return "login";
	}
	
	@GetMapping("/myTeams")
	public String getMyTeamsPage(@PathVariable(value="id") int id, Model model, RedirectAttributes ra) {
		
		try {
			model.addAttribute("user", loggedUser);
			return "myTeams";
		}
		catch (RuntimeException e) {
			ra.addFlashAttribute(e.getMessage());
			return "redirect:/";
		}
	}
}
