package com.example.backend.domain.cars;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс репозитория, в котором хранятся автомобили.
 */
@Repository
public interface CarRepository extends CrudRepository<CarEntity, UUID> {
    List<CarEntity> findByBrand(String brand);

    List<CarEntity> findByBrandAndModel(String brand, String model);
}
