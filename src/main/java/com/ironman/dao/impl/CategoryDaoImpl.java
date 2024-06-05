package com.ironman.dao.impl;

import com.ironman.dao.CategoryDao;
import com.ironman.dao.ConnectionCore;
import com.ironman.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl  implements CategoryDao {
    @Override
    public List<Category> findAll() throws Exception {
       // Attributes

        List<Category> categories = new ArrayList<>();

        Category category;
        String sqlQuery;

        //process

        //sql query
        sqlQuery = "select id, name, description, url_key, state, created_at, updated_at from categories";

        try (
                //Get connection
                Connection connection = new ConnectionCore().getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

                //ResultSet
                ResultSet resultSet = preparedStatement.executeQuery();

        ){

            //Set Data
            while(resultSet.next()){
                category = new Category();

                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                category.setUrlKey(resultSet.getString("url_key"));
                category.setState(resultSet.getString("state"));

                Timestamp createdAt = resultSet.getTimestamp("created_at");
                if(createdAt != null) {
                    category.setCreateAt(createdAt.toLocalDateTime());
                }

                Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                if (updatedAt != null) {
                    category.setUpdateAt(updatedAt.toLocalDateTime());
                }


                categories.add(category);


            }


        }

        //result
        return categories;
    }

    @Override
    public Category findById(Long id) throws Exception {

        //Attributes
        Category category = null;
        String sqlQuery;

        //Process


        sqlQuery = "select id, name, description, url_key, state, created_at, updated_at from categories where id = ?";

        try (
                //Get connection
                Connection connection = new ConnectionCore().getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);



        ){

            // set parameter

            preparedStatement.setLong(1, id);

            try(
                    //ResultSet
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                //Set Data
                if(resultSet.next()){
                    category = new Category();

                    category.setId(resultSet.getLong("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                    category.setUrlKey(resultSet.getString("url_key"));
                    category.setState(resultSet.getString("state"));

                    Timestamp createdAt = resultSet.getTimestamp("created_at");
                    if(createdAt != null) {
                        category.setCreateAt(createdAt.toLocalDateTime());
                    }

                    Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                    if (updatedAt != null) {
                        category.setUpdateAt(updatedAt.toLocalDateTime());
                    }


                }


            }


        }

        //Result

        return category;

    }

    @Override
    public int create(Category category) throws Exception {
        // Attributes
        int result = 0;
        String sqlQuery;

        //Process

        sqlQuery = "insert into categories (name, description, url_key, state, created_at, updated_at) values(?, ?, ?, ?, ?)";

        try (
                //Connection
                Connection connection = new ConnectionCore().getConnection();
                //Prepare Statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                ){

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, category.getUrlKey());
            preparedStatement.setString(4, category.getState());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(category.getCreateAt()));

            // Execute Query

            result = preparedStatement.executeUpdate();



        }catch (Exception e){

        }

        //Result
    }

    @Override
    public int update(Long id, Category category) throws Exception {
        return 0;
    }

    @Override
    public void deleteById(Long id) throws Exception {

    }
}
