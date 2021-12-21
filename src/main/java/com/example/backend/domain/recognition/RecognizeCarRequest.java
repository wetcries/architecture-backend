package com.example.backend.domain.recognition;

import lombok.Data;

/**
 * DTO отправки фото в формате base64 для распознавания автомобиля.
 */
@Data
public class RecognizeCarRequest {
    private String content;
}
