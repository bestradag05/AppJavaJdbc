package com.ironman;

import com.ironman.application.dto.category.CategoryDto;
import com.ironman.application.dto.category.CategorySmallDto;
import com.ironman.application.service.CategoryService;
import com.ironman.application.service.Impl.CategoryServiceImpl;
import com.ironman.persistence.entity.Category;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            CategoryService categoryService = new CategoryServiceImpl();

//            List<CategorySmallDto> categories = categoryService.findAll();
//
//           System.out.println("Categories start:");
//            for (CategorySmallDto category : categories) {
//                System.out.println("Id: " + category.getId());
//                System.out.println("Name: " + category.getName());
//                System.out.println();
//            }
//
//            System.out.println("Categories end.");

            CategoryDto category = categoryService.findById(66L);


            System.out.println("Id: " + category.getId());
            System.out.println("Name: " + category.getName());
            System.out.println("Description: " + category.getDescription());
            System.out.println("Url key: " + category.getUrlKey());
            System.out.println("State: " + category.getState());
            System.out.println("Created at: " + category.getCreateAt());


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