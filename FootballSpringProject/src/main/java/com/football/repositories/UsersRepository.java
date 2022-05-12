package com.football.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.football.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
}
