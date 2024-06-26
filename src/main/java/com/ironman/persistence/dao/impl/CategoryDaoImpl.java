package com.ironman.persistence.dao.impl;

import com.ironman.persistence.dao.CategoryDao;
import com.ironman.persistence.dao.core.ConnectionCore;
import com.ironman.persistence.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends ConnectionCore implements CategoryDao {
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
                Connection connection = getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

                //ResultSet
                ResultSet resultSet = preparedStatement.executeQuery();

        ) {

            //Set Data
            while (resultSet.next()) {
                category = mapResultSetCategory(resultSet);
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
                Connection connection = getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);


        ) {

            // set parameter

            preparedStatement.setLong(1, id);

            try (
                    //ResultSet
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                //Set Data
                if (resultSet.next()) {

                    category = mapResultSetCategory(resultSet);


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
        sqlQuery = "insert into categories (name, description, url_key, state, created_at) values(?, ?, ?, ?, ?)";

        try (
                //Connection
                Connection connection = getConnection();
                //Prepare Statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, category.getUrlKey());
            preparedStatement.setString(4, category.getState());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(category.getCreateAt()));

            // Execute Query

            result = preparedStatement.executeUpdate();


        } catch (Exception e) {

        }

        //Result

        return result;
    }

    @Override
    public int update(Long id, Category category) throws Exception {
        // Attributes
        int result = 0;
        String sqlQuery;

        //Process
        sqlQuery = "update categories set  name=?, description=?, url_key=?, updated_at=? where id=?";

        try (
                //Connection
                Connection connection = getConnection();
                //Prepare Statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, category.getUrlKey());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(category.getUpdateAt()));
            preparedStatement.setLong(5, id);

            // Execute Query

            result = preparedStatement.executeUpdate();


        } catch (Exception e) {

        }

        //Result

        return result;
    }

    @Override
    public void deleteById(Long id) throws Exception {

        // Attributes
        int result = 0;
        String sqlQuery;

        //Process
        sqlQuery = "delete from categories where id = ?";

        try (
                //Connection
                Connection connection = getConnection();
                //Prepare Statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {

            preparedStatement.setLong(1, id);

            // Execute Query

            preparedStatement.executeUpdate();


        } catch (Exception e) {

        }


    }


    private Category mapResultSetCategory(ResultSet resultSet) throws Exception {
        Category category = new Category();

        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("name"));
        category.setDescription(resultSet.getString("description"));
        category.setUrlKey(resultSet.getString("url_key"));
        category.setState(resultSet.getString("state"));

        Timestamp createdAt = resultSet.getTimestamp("created_at");
        if (createdAt != null) {
            category.setCreateAt(createdAt.toLocalDateTime());
        }

        Timestamp updatedAt = resultSet.getTimestamp("updated_at");
        if (updatedAt != null) {
            category.setUpdateAt(updatedAt.toLocalDateTime());
        }


        return category;

    }


}
