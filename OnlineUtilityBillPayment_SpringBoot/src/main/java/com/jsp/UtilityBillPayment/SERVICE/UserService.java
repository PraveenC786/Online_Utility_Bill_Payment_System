package com.jsp.UtilityBillPayment.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.UtilityBillPayment.DTO.Role;
import com.jsp.UtilityBillPayment.DTO.User;
import com.jsp.UtilityBillPayment.REPOSITORY.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	

	// to register user
	public User registerUser(User user) {

		// if user's role is null , we set it to default role, ie..USER
		if (user.getRole() == null) {
			user.setRole(Role.USER);
		}
		// if user's role is != null , the we save the object into DB.
		return userRepo.save(user);
	}

	// to get user based on ID
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}
	
	// to get all users
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
}
