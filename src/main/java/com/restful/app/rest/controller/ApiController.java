package com.restful.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.app.rest.model.User;
import com.restful.app.rest.repository.UserRepository;

@RestController
public class ApiController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping(value="")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="users")
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	@PostMapping(value="save")
	public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "saved...";
	}
	
	@PutMapping(value="update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable long id) {
		User updatedUser = repository.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		repository.save(updatedUser);
		return "updated...";
	}
	
	@DeleteMapping(value="delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = repository.findById(id).get();
		repository.delete(deleteUser);
		return "User with id: " + id + " deleted.";
	}

}
