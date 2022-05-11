package com.football.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.football.models.Team;

@Repository
public interface TeamsRepository extends CrudRepository<Team, Integer>{
	
}
