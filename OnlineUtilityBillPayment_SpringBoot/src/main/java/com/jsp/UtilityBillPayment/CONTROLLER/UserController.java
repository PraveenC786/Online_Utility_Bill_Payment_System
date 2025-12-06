package com.jsp.UtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.UtilityBillPayment.DTO.User;
import com.jsp.UtilityBillPayment.SERVICE.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// to register user
	// client has to send post request, so postMapping
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	
	// to get a user based on user id
	@GetMapping("/get")
	public ResponseEntity<User> getUser(@RequestParam Long id){
		return userService.getUserById(id) // returns Optional object
				.map(ResponseEntity:: ok) 
				// Optional.map(...) is used when value is present
				// ResponseEntity:: ok --> this means ResponseEntity.ok(user);
				
				.orElse(ResponseEntity.notFound().build());
				//Optional.orElse is used when value is not present
				// ResponseEntity.notFound().build() --> this sends NOT FOUND response with no body (no object) to the client. 
	}
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}

















