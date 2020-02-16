package com.example.furniture_warehouse.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Type")
    private String type;


    //relacja 2 kierunkowa
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Set<Furniture> furnitures = new HashSet<>();

    public Type() {
    }

    public Type(String type){
        this.type=type;
    }
    public  Type(String type,Set<Furniture>furnitures){
        this.type=type;
        this.furnitures=furnitures;
    }



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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
