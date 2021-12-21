package com.example.backend.domain.cars;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер с основными CRUD операциями с сущностями, представляющие автомобили.
 */
@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @Operation(summary = "Add a new car")
    @PostMapping
    public CarEntity addCar(@RequestBody CarEntity carEntity) {
        return carsService.addCar(carEntity);
    }

    @Operation(summary = "Get car by its id")
    @GetMapping("/{id}")
    public CarEntity getCar(@PathVariable UUID id) {
        return carsService.getCar(id);
    }

    @Operation(summary = "Get all cars")
    @GetMapping
    public List<CarEntity> getAllCars() {
        return carsService.getCars();
    }

    @Operation(summary = "Delete car by its id")
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carsService.deleteCar(id);
    }

    @Operation(summary = "Update car by its id")
    @PutMapping("/{id}")
    public CarEntity updateCar(@PathVariable UUID id, @RequestBody CarEntity carEntity) {
        return carsService.updateCar(id, carEntity);
    }
}
