package com.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.football.models.Team;
import com.football.services.TeamsService;

@Controller
public class TeamsController {
	
	@Autowired
	private TeamsService teamsSerivce;

	@GetMapping("/teams")
	public String getTeams(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		model.addAttribute("teams", teamsSerivce.getAllTeams());
		return "teams";
	}
	
	@PostMapping("/addTeam")
	public String saveTeam(@ModelAttribute("team") Team team) {
		teamsSerivce.addTeam(team);		
		return "redirect:/teams";
	}
	
	@GetMapping("/teams/editTeam/{id}")
	public String editTeam(@PathVariable(value="id") int id, Model model, RedirectAttributes ra) {
		try {
			Team team = teamsSerivce.getTeamById(id);
			model.addAttribute("team", team);
			return "editTeam";
		}
		catch (RuntimeException e) {
			ra.addFlashAttribute(e.getMessage());
			return "redirect:/teams";
		}
	}
	
	@PostMapping("/deleteTeam")
	public String deleteTeam(@ModelAttribute("team") Team team) {
		teamsSerivce.deleteTeamById(team.getId());
		return "redirect:/teams";
	}
}
