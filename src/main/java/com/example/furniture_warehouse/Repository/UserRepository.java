package com.example.furniture_warehouse.Repository;

import com.example.furniture_warehouse.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
