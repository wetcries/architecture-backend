package com.example.backend.domain.recognition;

import com.example.backend.domain.recognition.client.RecognitionResponse;
import lombok.Data;

import java.util.Map;

/**
 * DTO используемов в API распознавания автомобилей.
 */
@Data
public class RecognizedCars {
    private Map<String, Double> carsWithProbabilities;
    private boolean confidence;

    public RecognizedCars(RecognitionResponse response) {
        this.carsWithProbabilities = response.getProbabilities();
        this.confidence = response.isConfidence();
    }
}
