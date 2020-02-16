package com.example.furniture_warehouse.Repository;


import com.example.furniture_warehouse.dao.Furniture;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepository extends CrudRepository<Furniture,Long> {

    Optional<Furniture> findById(Long id);

    Iterable<Furniture> findAll();

     Furniture save(Furniture furniture);

    void deleteById(Long id);
}
