package com.ironman.dao;

import com.ironman.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface CategoryDao {

    List<Category> findAll() throws  Exception;

    Category findById(Long id) throws  Exception;

    int create(Category category) throws  Exception;

    int update(Long id, Category category) throws  Exception;

    void deleteById(Long id) throws Exception;

}
