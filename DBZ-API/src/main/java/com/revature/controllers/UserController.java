package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ClientMessage;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@PostMapping("/register")
	public ClientMessage registerNewProfile(@RequestBody User user) {
		return userServ.registerUser(user) ? REGISTATION_SUCCESSFUL : REGISTATION_FAILED;
	}
	
	@GetMapping("/view-all")
	public List<User> getAllUsers(){
		return userServ.getAllUsers();
	}

}
