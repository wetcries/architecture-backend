package com.example.backend.domain.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Сервис, отвечающий за основные CRUD операци по работе с автомобилями
 * (создание, изменение, удаление, поиск автомобилей).
 */
@Service
public class CarsService {
    CarRepository carRepository;
    private final Set<String> photoTypes = Set.of("main", "front", "back", "left", "right");

    @Autowired
    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarEntity addCar(CarEntity car) {
        verifyAddCar(car);
        return carRepository.save(car);
    }

    public CarEntity getCar(UUID id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<CarEntity> getCars() {
        return StreamSupport.stream(carRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    public CarEntity updateCar(UUID id, CarEntity car) {
        carRepository.findById(id).orElseThrow();
        car.setId(id);
        return carRepository.save(car);
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

    public List<CarEntity> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<CarEntity> findByBrandAndModel(String brand, String model) {
        return carRepository.findByBrandAndModel(brand, model);
    }

    private void verifyAddCar(CarEntity car) {
        Assert.isTrue(car.getBrand() != null && !car.getBrand().isEmpty(),
                "Brand must be provided");
        Assert.isTrue(car.getModel() != null && !car.getModel().isEmpty(),
                "Model must be provided");
        Assert.isTrue(car.getMinPrice() > 0, "Price must be provided");
        car.getPhotos().keySet().forEach(k -> {
            if (!photoTypes.contains(k))
                throw new IllegalArgumentException("Invalid photo type: " + k);
        });
    }
}
