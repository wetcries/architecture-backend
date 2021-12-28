package com.example.backend.domain.recognition;

import com.example.backend.domain.recognition.client.RecognitionClient;
import com.example.backend.domain.recognition.client.RecognitionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис распознавания автомобилей.
 */
@Service
public class RecognitionService {
    RecognitionClient recognitionClient;

    @Autowired
    public RecognitionService(RecognitionClient recognitionClient) {
        this.recognitionClient = recognitionClient;
    }

    RecognizedCars recognizeCar(String base64Image) {
        return new RecognizedCars(recognitionClient.recognition(new RecognitionRequest(base64Image)));
    }
}
