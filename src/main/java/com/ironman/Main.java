package com.ironman;

import com.ironman.dao.CategoryDao;
import com.ironman.dao.ConnectionCore;
import com.ironman.dao.impl.CategoryDaoImpl;
import com.ironman.dao.impl.CategoryStoreImp;
import com.ironman.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            CategoryDao categoryDao = new CategoryDaoImpl();

            List<Category> categories = categoryDao.findAll();

           System.out.println("Categories start:");
            for (Category category : categories) {
                System.out.println("Id: " + category.getId());
                System.out.println("Name: " + category.getName());
                System.out.println("Description: " + category.getDescription());
                System.out.println("Url key: " + category.getUrlKey());
                System.out.println("State: " + category.getState());
                System.out.println("Created at: " + category.getCreateAt());
                System.out.println();
            }

            System.out.println("Categories end.");

            /*Category category = categoryDao.findById(66L);


            System.out.println("Id: " + category.getId());
            System.out.println("Name: " + category.getName());
            System.out.println("Description: " + category.getDescription());
            System.out.println("Url key: " + category.getUrlKey());
            System.out.println("State: " + category.getState());
            System.out.println("Created at: " + category.getCreateAt());*/


//            Category category = new Category();
//            category.setName("Categoria Bryan2");
//            category.setDescription("Sin detalles");
//            category.setUrlKey("categoria-a");
//            category.setState("A");
//            category.setCreateAt(LocalDateTime.now());
//
//            int result = categoryDao.create(category);
//            System.out.println("Create: " + result);


//            Category category = new Category();
//            category.setName("Categoria Bryan2");
//            category.setDescription("Sin detalles");
//            category.setUrlKey("categoria-a2");
//            category.setUpdateAt(LocalDateTime.now());
//
//            int result = categoryDao.update(108L, category);
//            System.out.println("Update: " + result);


//            categoryDao.deleteById(108L);


        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

    }
}