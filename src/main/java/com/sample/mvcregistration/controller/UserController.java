package com.sample.mvcregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.mvcregistration.services.Loginserv;

@Controller
public class UserController {
	  @Autowired
	    private Loginserv loginService;

	    @PostMapping("/login")
	    public @ResponseBody LoginResponse login(@RequestBody LoginRequest loginRequest) {
	        boolean isValidUser = loginService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
	        if (isValidUser) {
	            return new LoginResponse("success", "Login successful");
	        } else {
	            return new LoginResponse("error", "Invalid email or password");
	        }
	    }
	}