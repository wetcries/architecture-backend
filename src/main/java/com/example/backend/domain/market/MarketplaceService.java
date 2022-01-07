package com.example.backend.domain.market;

import com.example.backend.domain.cars.CarRepository;
import com.example.backend.domain.cars.CarsService;
import com.example.backend.domain.market.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис, предоставляющий методы по работы с маркетплейсом.
 */
@Service
public class MarketplaceService {
    CarsService carsService;

    @Autowired
    public MarketplaceService(CarsService carsService) {
        this.carsService = carsService;
    }

    public List<Car> getMarketplaceCars() {
        return carsService.getCars().stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCarsByBrand(String brand) {
        return carsService.findByBrand(brand).stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCarsByBrandAndModel(String brand, String model) {
        return carsService.findByBrandAndModel(brand, model).stream().map(Car::new).collect(Collectors.toList());
    }

    public Car getCarById(String id) {
        var car = carsService.getCar(UUID.fromString(id));
        if (car != null)
            return new Car(car);
        throw new CarNotFoundException("Car with id " + id + "was not found");
    }
}
