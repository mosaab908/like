package com.revature.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.demo.model.Fourniture;
import com.revature.demo.util.ConnectionFactory;

public class FournitureDaoImp implements FournitureDao{
	
	Connection connection;
	
	public FournitureDaoImp() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public Fourniture save(Fourniture fourniture) {
		
		 // Use prepared statement to prevent SQL injection
			String sql = "insert into fourniture values(default, ?,?,?,?);";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, fourniture.getName_fourniture());
				preparedStatement.setInt(2, fourniture.getSize_fourniture());
				preparedStatement.setString(3, fourniture.getColor_fourniture());
				preparedStatement.setInt(4, fourniture.getHome_id());
				
				// this will actually execute the statement
				int count = preparedStatement.executeUpdate();
				
				 // if count is 1, that means success, we've updated the table:
	            if(count == 1) {
	                return fourniture;
	            }
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Fourniture> getAllFourniture() {
		Fourniture fourniture = null;
		List<Fourniture> fournitureList = new ArrayList<Fourniture>();
		
		final String sql = "SELECT * FROM fourniture";
		
		
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
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		
		return fournitureList;
	}

	@Override
	public Fourniture selectFournitureById(Integer fourniture_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fourniture> getFournitureByHomeId(Integer id) {
		
		List<Fourniture> fournitures = getAllFourniture();
		List<Fourniture> homeFournitures = new ArrayList<Fourniture>();
		
		for(Fourniture fourniture : fournitures) {
			if (fourniture.getHome_id() == id) {
				homeFournitures.add(fourniture);
			}
		}
		// TODO Auto-generated method stub
		System.out.println(fournitures);
		return homeFournitures;
	}

}
