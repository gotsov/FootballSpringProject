package com.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.football.models.Team;
import com.football.services.TeamsService;

@Controller
@RequestMapping("/teams")
public class TeamsController {
	
	@Autowired
	private TeamsService teamsSerivce;

	@GetMapping
	public String getTeams(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		model.addAttribute("teams", teamsSerivce.getAllTeams());
		return "teams";
	}
	
	@PostMapping
	public String saveTeam(@ModelAttribute("team") Team team) {
		teamsSerivce.addTeam(team);
		return "redirect:/teams";
	}
}
