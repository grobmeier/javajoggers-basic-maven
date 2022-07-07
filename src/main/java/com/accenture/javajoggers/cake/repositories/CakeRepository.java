package com.accenture.javajoggers.cake.repositories;

import com.accenture.javajoggers.cake.entities.Cake;
import com.accenture.javajoggers.cake.entities.CakeIngredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CakeRepository {

    Connection connection;

    public CakeRepository(Connection connection) {
        this.connection = connection;
    }

    public void addCake(Cake cake) {
        try {
            String sql = "insert into cakes (cake_name) values (?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cake.getName());
            preparedStatement.executeUpdate();

            // Now the cake is in the database :-)
            // please give me the freshly generated primary keys for the new albums:
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int cakeId = generatedKeys.getInt(1);

            addCakeIngredients(cakeId, cake.getCakeIngredients());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addCakeIngredients(Integer cakeId, List<CakeIngredient> cakeIngredients) {
        // insert ingredients here
        for (CakeIngredient cakeIngredient : cakeIngredients) {
            addCakeIngredients(cakeId, cakeIngredient);
        }
    }

    public void addCakeIngredients(Integer cakeId, CakeIngredient ingredient) {
        try {
            String sql = "insert into cake_ingredients " +
                    " (ingredient_name, amount, cakes_id) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ingredient.getIngredientName());
            preparedStatement.setInt(2, ingredient.getAmount());
            preparedStatement.setInt(3, cakeId);
            preparedStatement.execute();
        } catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    public List<Cake> listCakes() {
        List<Cake> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cakes");
            while(resultSet.next()) {
                Cake cake = new Cake();
                cake.setId(resultSet.getInt("id"));
                cake.setName(resultSet.getString("cake_name"));
                result.add(cake);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        for (Cake cake : result) {
            ArrayList<CakeIngredient> cakeIngredients = readIngredientsByCake(cake.getId());
            cake.setCakeIngredients(cakeIngredients);
        }
        return result;
    }

    public ArrayList<CakeIngredient> readIngredientsByCake(Integer cakeId) {
        ArrayList<CakeIngredient> result = new ArrayList<>();
        try {
            String sql =
                    "select * " +
                    "from cake_ingredients " +
                    "where cakes_id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cakeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                CakeIngredient ingredient = new CakeIngredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setIngredientName(resultSet.getString("ingredient_name"));
                ingredient.setAmount(resultSet.getInt("amount"));

                result.add(ingredient);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

}
