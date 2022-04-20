package com.vcd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vcd.entity.*;
import com.vcd.exception.UserNotFoundException;
import com.vcd.repository.UserRepository;

@RestController
@RequestMapping("api/v1")
public class UserController {
    
	@Autowired
	private UserRepository userRepository;
	
	//get employee information - id, name, location, salary, contactNo, password
	@GetMapping("/user")
	public List<User> getEmployee(){
		return this.userRepository.findAll();
	}
	
	//Get Employee information with the help of id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable (value="id") Integer Id)
	throws UserNotFoundException{
		User user=userRepository.findById(Id).orElseThrow(() ->
		new UserNotFoundException("User not found for this id : "+Id));
		return ResponseEntity.ok().body(user);
	}
	
	//Save Employee information
	@PostMapping("user")
	public User createEmployee(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//Update all employee information
	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable (value="id") Integer Id,
		  @Validated @RequestBody	User userDetails)
	throws UserNotFoundException{
		User user =userRepository.findById(Id).orElseThrow();
		
		user.setRequirementId(userDetails.getRequirementId());
		user.setDescription(userDetails.getDescription());
		user.setPriority(userDetails.getPriority());
		return ResponseEntity.ok(this.userRepository.save(user));
	}
	
	//Delete employee information 
	@DeleteMapping("user/{id}")
	public Map<String, Boolean> deleteUserById(@PathVariable (value="id") Integer Id)
	throws UserNotFoundException{
		User user =userRepository.findById(Id)
				.orElseThrow(() -> new UserNotFoundException("User is not found by that id :: "+Id));
	this.userRepository.delete(user);
	
	Map<String, Boolean> response=new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
	}
	
}