package com.revature.dao;

import com.revature.model.Superhero;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "insert into superhero values(default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            // this will actually execute the statement
            int count = preparedStatement.executeUpdate();

            // if count is 1, that means success, we've updated the table:
            if(count == 1) {
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Superhero getById(int id) {
        String sql = "select * from superhero where id = 'id';";

        try (Statement statement = connection.createStatement();)
        {
            ResultSet set = statement.executeQuery(sql);

            Superhero superhero = new Superhero(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getString(5),set.getString(6),set.getString(7));
// System.out.println("\n");
            return superhero;

        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;



    }

    @Override
    public List<Superhero> getAll() {
        Superhero superhero = null;
        List<Superhero> superheroList = new ArrayList<Superhero>();

        final String sql = "SELECT * FROM superhero";

        try (Statement statement = connection.createStatement();)
        {
            ResultSet set = statement.executeQuery(sql);

            while(set.next()) {
                superhero = new Superhero(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7)
                );
// System.out.println("\n");
                superheroList.add(superhero);
            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();

        }

        return superheroList;
    }

    @Override
    public Superhero updateSuperhero(Superhero superhero) {
        String sql = " update superhero set superhero_name = ? where tId = ? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setInt(2, superhero.getId());

            int count = preparedStatement.executeUpdate(); // DML, we use executeUpdate instead of executeQuery
            //ResultSet resultSet = preparedStatement.executeQuery();

            if (count == 1) {
                System.out.println("Update successful!");
                return  superhero;
            } else {
                System.out.println("Something went wrong with the update");
                if (count == 0) {
                    System.out.println("No rows were affected");
                } else {
                    System.out.println("Many rows were affected");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return null
        return superhero;
    }

    @Override
    public void deleteSuperhero(int id) {
// TODO Auto-generated method stub

    }

    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}

    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)

