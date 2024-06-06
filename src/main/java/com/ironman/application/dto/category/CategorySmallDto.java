package com.ironman.application.dto.category;

public class CategorySmallDto {

    //Atributes
    private Long id;
    private String name;


    // Constructor
    public CategorySmallDto() {
    }

    public CategorySmallDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //encapsulates


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
