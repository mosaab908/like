package com.revature.demo.dao;

import java.util.List;

import com.revature.demo.model.Fourniture;

public interface FournitureDao {
	//CRUD
	Fourniture save(Fourniture fourniture);
	List<Fourniture> getAllFourniture();
	Fourniture selectFournitureById(Integer fourniture_id);
	List<Fourniture> getFournitureByHomeId(Integer id);

}
