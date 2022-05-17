package com.football.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.football.models.Team;
import com.football.repositories.TeamsRepository;
@Service
public class TeamsService implements ITeamsService{

	private final TeamsRepository repository;
	
	public TeamsService(TeamsRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public List<Team> getAllTeams() {
		return (List<Team>) repository.findAll();
	}

	@Override
	public void addTeam(Team team) {
		repository.save(team);
	}

	@Override
	public Team getTeamById(int id) {
		Optional<Team> optionalTeam = repository.findById(id);
		Team team;
		
		if(optionalTeam.isPresent())
			team = optionalTeam.get();
		else
			throw new RuntimeException("Team with id '" + id + "' not found.");
		
		return team;
	}

	@Override
	public void deleteTeamById(int id) {
		repository.deleteById(id);
	}
}
