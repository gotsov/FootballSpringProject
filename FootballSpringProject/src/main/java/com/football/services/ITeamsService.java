package com.football.services;

import java.util.List;

import com.football.models.Team;

public interface ITeamsService {
	List<Team> getAllTeams();
	void addTeam(Team team);
	Team getTeamById(int id);
	void deleteTeamById(int id);
}
