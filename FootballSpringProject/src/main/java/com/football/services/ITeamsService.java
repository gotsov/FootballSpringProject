package com.football.services;

import java.util.List;

import com.football.models.Team;

public interface ITeamsService {
	List<Team> findAll();
}
