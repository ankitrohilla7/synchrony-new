package com.synchrony.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synchrony.project.entity.User;
import com.synchrony.project.service.CustomUserDetailsService;

@RestController
public class RegitrationController {
	
    Logger logger = LoggerFactory.getLogger(RegitrationController.class);


	@Autowired  
	CustomUserDetailsService customUserDetailsService;  
	
    @PostMapping(value = "api/v1/signup")
    public String saveUser(@RequestBody User user) {
    	logger.info("Registration started");
    	customUserDetailsService.saveOrUpdate(user);
        return "User registerted successfully";
    }
}
