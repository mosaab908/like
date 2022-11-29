package com.revature.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.model.Home;
import com.revature.demo.service.HomeService;



@RestController
@RequestMapping("/api/home")
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "http://revashoes.s3-website-us-west-1.amazonaws.com"}, allowCredentials = "true")
public class HomeController {
	private HomeService homeService;
	
	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
    @PostMapping("/register")
    public ResponseEntity<Home> register(@RequestBody Home registerRequest) {
    	Home created = new Home(0,
                registerRequest.getName_home(),
                registerRequest.getSize_home(),
                registerRequest.getCost_home());

        return ResponseEntity.status(HttpStatus.CREATED).body(homeService.register(created));
    }
	
	@GetMapping
    public ResponseEntity<List<Home>> getInventory() {
        return ResponseEntity.ok(homeService.findAll());
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Home> gethomeById(@PathVariable("id") int id) {
        Optional<Home> optional = homeService.findById(id);

        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }


    }
	

