package com.revature.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.demo.model.Home;


@Repository
public interface HomeRepository extends JpaRepository<Home, Integer>{
	
}
