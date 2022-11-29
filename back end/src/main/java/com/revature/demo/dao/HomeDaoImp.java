package com.revature.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.demo.model.Fourniture;
import com.revature.demo.model.Home;
import com.revature.demo.util.ConnectionFactory;

public class HomeDaoImp implements HomeDao{
	Connection connection;
	
	public HomeDaoImp() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public Home save(Home home) {
		 // Use prepared statement to prevent SQL injection
		String sql = "insert into home values(default, ?,?,?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, home.getName_home());
			preparedStatement.setInt(2, home.getSize_home());
			preparedStatement.setInt(3, home.getCost_home());
			
			// this will actually execute the statement
			int count = preparedStatement.executeUpdate();
			
			 // if count is 1, that means success, we've updated the table:
            if(count == 1) {
                return home;
            }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Home> getAllHome() {
		Home home = null;
		List<Home> homeList = new ArrayList<Home>();
		
		final String sql = "SELECT * FROM home";
		
		try (Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				while(set.next()) {
					 home = new Home(
							 	set.getInt(1),
								set.getString(2),
								set.getInt(3),
								set.getInt(4)
								);
					// System.out.println("\n");
					homeList.add(home);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		
		return homeList;

	}

	@Override
	public void getHomeByName(String name_home) {
		
		Home home = null;
		List<Home> homeList = new ArrayList<Home>();
		
		final String sql = "SELECT * FROM home, fourniture where (name_home = '\"+name_home+\"') and (home.home_id = fourniture.home_id) ";
		
		try (Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				 home = new Home(
						 	set.getInt(1),
							set.getString(2),
							set.getInt(3),
							set.getInt(4)
							);
				// System.out.println("\n");
				homeList.add(home);
				System.out.println(homeList);
				System.out.println("bonjour");
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		
	}

	@Override
	public List<Fourniture> getFournitureByName(String name_home) {
		Fourniture fourniture = null;
		List<Fourniture> fournitureList = new ArrayList<Fourniture>();
		
		final String sql = "SELECT * FROM home, fourniture where (name_home = '\"+name_home+\"') and (home.home_id = fourniture.home_id) ";
		
		try (Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				 fourniture = new Fourniture(
						 	set.getInt(1),
							set.getString(2),
							set.getInt(3),
							set.getString(4),
							set.getInt(5)
							);
				// System.out.println("\n");
				fournitureList.add(fourniture);
				System.out.println(fournitureList);
				System.out.println("bonjour");
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		return fournitureList;
	}

	

}
