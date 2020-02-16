package com.example.furniture_warehouse;

import com.example.furniture_warehouse.Repository.FurnitureRepository;
import com.example.furniture_warehouse.dao.Furniture;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FurnitureWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnitureWarehouseApplication.class, args);

    }

}