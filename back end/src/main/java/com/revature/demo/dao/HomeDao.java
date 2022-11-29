package com.revature.demo.dao;

import java.util.List;

import com.revature.demo.model.Fourniture;
import com.revature.demo.model.Home;

public interface HomeDao {
	//CRUD
	Home save(Home home);
	List<Home> getAllHome();
	void getHomeByName(String name_home);
	List<Fourniture> getFournitureByName(String name_home);
}
