package com.revature.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.model.Home;

@RestController
@RequestMapping("/api/fourniture")
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "http://revashoes.s3-website-us-west-1.amazonaws.com"}, allowCredentials = "true")
public class FournitureController {
	
	
	

}
