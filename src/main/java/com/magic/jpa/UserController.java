package com.magic.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<UserRecord> getAll() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public void addUser(@RequestBody UserRecord ur) {
		userService.addUser(ur);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public void getUser(@PathVariable String userId) {
		userService.getUser(userId);
	}
}
