package com.example.backend.domain.recognition.client;

import lombok.Data;

import java.util.Map;

/**
 * DTO для взаимодействия с сервисом
 */
@Data
public class RecognitionResponse {
    private Map<String, Double> probabilities;
    private boolean confidence = true;
}
