package com.example.furniture_warehouse.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;

    public User() {
    }
    public User(String name,String surname){
        this.name=name;
        this.surname=surname;
    }
    public User(String name,String surname,Set<Furniture>furnitures){
        this.name=name;
        this.surname=surname;
        this.furnitures=furnitures;
    }
    @ManyToMany(mappedBy = "users")
    private Set<Furniture> furnitures;


    public Set<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(Set<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
