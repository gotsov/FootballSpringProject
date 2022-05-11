package com.football.services;

import java.util.List;

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
	public List<Team> findAll() {
		return (List<Team>) repository.findAll();
	}

}
