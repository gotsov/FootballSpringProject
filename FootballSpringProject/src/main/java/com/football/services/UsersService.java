package com.football.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.football.models.User;
import com.football.repositories.UsersRepository;

@Service
public class UsersService implements IUsersService{
	private final UsersRepository userRepository;
	
	public UsersService(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public Boolean userExists(User user) {
		User loginUser = userRepository.findByUsername(user.getUsername());
		
		return (loginUser != null && loginUser.getPassword().equals(loginUser.getPassword())) ? true : false;
	}
}
