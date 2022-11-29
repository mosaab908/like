package com.revature.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.demo.dao.FournitureDao;
import com.revature.demo.dao.FournitureDaoImp;
import com.revature.demo.dao.HomeDao;
import com.revature.demo.dao.HomeDaoImp;
import com.revature.demo.model.Fourniture;
import com.revature.demo.model.Home;

@SpringBootApplication
public class Postproject0Application {

	public static void main(String[] args) {
		SpringApplication.run(Postproject0Application.class, args);
	    
	        /*
	         // use -1 as a placeholder for id:
	         // add new home
	        Home home = new Home(-1, "home5", 90, 50000);
	        // Not good code, we should get the DAO from a factory:
	        HomeDao homeDao = new HomeDaoImp();
	        homeDao.save(home);
	        System.out.println(home.getHome_id());*/
		
			/*
			 // get all home
			HomeDao homeDao = new HomeDaoImp();
			List<Home> homeList = homeDao.getAllHome();
			for (Home home : homeList) {
				System.out.println(home);
			}
	    */
		
		/*// get all fourniture
		FournitureDao fournitureDao = new FournitureDaoImp();
		List<Fourniture> fournitureList = fournitureDao.getAllFourniture();
		for (Fourniture fourniture : fournitureList) {
			System.out.println(fourniture);
		}
		*/
		
		/*// get fourniture by home id
		FournitureDao fournitureDao = new FournitureDaoImp();
		List<Fourniture> fournitureList = fournitureDao.getFournitureByHomeId(2);
		System.out.println(fournitureList);
		*/
		
		/*//add new fourniture
        Fourniture fourniture = new Fourniture(-1, "table", 15, "pink", 1);
        // Not good code, we should get the DAO from a factory:
        FournitureDao fournitureDao = new FournitureDaoImp();
        fournitureDao.save(fourniture);
        System.out.println(fourniture.getHome_id());
		*/
		
		
		System.out.println("hello");
	}

}
