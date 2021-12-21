package com.example.backend.domain.recognition;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер по работе с распознаванием автомобилей по фото.
 */
@RestController
@RequestMapping("/api/v1/recognition")
public class RecognitionController {
    private final RecognitionService recognitionService;

    @Autowired
    public RecognitionController(RecognitionService recognitionService) {
        this.recognitionService = recognitionService;
    }

    @Operation(summary = "Recognize car by base64 photo")
    @PostMapping
    RecognizedCars recognizeCar(@RequestBody RecognizeCarRequest request) {
        return recognitionService.recognizeCar(request.getContent());
    }
}
