package com.synchrony.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
    Logger logger = LoggerFactory.getLogger(HomeController.class);


    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
    
    
}
