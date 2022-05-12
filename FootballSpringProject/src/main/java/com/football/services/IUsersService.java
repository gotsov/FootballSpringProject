package com.football.services;

import java.util.List;

import com.football.models.User;

public interface IUsersService {
	List<User> getAllUsers();
	void addUser(User user);
	Boolean userExists(User user);
}
