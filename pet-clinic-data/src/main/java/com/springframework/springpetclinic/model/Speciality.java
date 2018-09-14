package com.springframework.springpetclinic.model;

/**
 * @author Ehtiram_Abdullayev on 9/14/2018
 * @project spring-pet-clinic
 */
public class Speciality extends  BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
