package com.example.furniture_warehouse.Repository;

import com.example.furniture_warehouse.dao.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type,Long> {
}
