package com.example.furniture_warehouse.Repository;

import com.example.furniture_warehouse.dao.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
