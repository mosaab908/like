package com.revature.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.demo.model.Home;
import com.revature.demo.repository.HomeRepository;


@Service
public class HomeService {
	
	private HomeRepository homeRepository;
	
	@Autowired
	public HomeService(HomeRepository homeRepository) {
		super();
		this.homeRepository = homeRepository;
	}

	
	public List<Home> findAll() {
		return homeRepository.findAll();
	}


	public Optional<Home> findById(int id) {
		return homeRepository.findById(id);
	}


	public Home register(Home created) {
		return homeRepository.save(created);
	}

}
