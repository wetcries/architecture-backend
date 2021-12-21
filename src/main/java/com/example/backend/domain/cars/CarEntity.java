package com.example.backend.domain.cars;

import com.example.backend.domain.market.Car;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Сущность автомобиля, которая хранится в базе данных.
 */
@Data
@Entity
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String brand;
    private String model;
    private double minPrice;
    @ElementCollection
    private Map<String, String> photos;

    public CarEntity(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.minPrice = car.getMinPrice();
        car.getPhotos().forEach(p -> this.photos.put(p.getType(), p.getLink()));
    }
}
