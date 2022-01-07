package com.example.backend.domain.market;

import com.example.backend.domain.cars.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * DTO сущность автомобиля, используемая в API.
 */
@Data
public class Car {
    private UUID id;
    /**
     * Бренд автомобиля.
     */
    private String brand;
    /**
     * Модель автомобиля.
     */
    private String model;
    /**
     * Минимальная цена автомобиля.
     */
    private double minPrice;
    /**
     * Список фотографий автомобиля.
     */
    private List<Photo> photos;

    /**
     * Сущность фотографии автомобиляю.
     */
    @Data
    @AllArgsConstructor
    public static class Photo {
        /**
         * Тип фотографии. Может иметь значение:
         * main - основное фото автомобиля
         * front - фото автомобиля спереди
         * back - фото автомобиля сзади
         * left - фото автомобиля слева
         * right - фото автомобиля справа
         */
        private String type;
        /**
         * Ссылка на фотографию.
         */
        private String link;
    }

    public Car(CarEntity carEntity) {
        this.id = carEntity.getId();
        this.brand = carEntity.getBrand();
        this.model = carEntity.getModel();
        this.minPrice = carEntity.getMinPrice();
        this.photos = carEntity.getPhotos().entrySet().stream()
                .map(e -> new Photo(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
