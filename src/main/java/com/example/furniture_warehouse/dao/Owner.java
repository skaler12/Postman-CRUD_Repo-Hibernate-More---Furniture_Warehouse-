package com.example.furniture_warehouse.dao;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Owner_Name")
    private String owner_name;

    public Owner() {
    }
    public Owner(String owner_name){
        this.owner_name=owner_name;
    }
    public Owner(String owner_name,Furniture furniture){
        this.owner_name=owner_name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", owner_name='" + owner_name + '\'' +

                '}';
    }
}
