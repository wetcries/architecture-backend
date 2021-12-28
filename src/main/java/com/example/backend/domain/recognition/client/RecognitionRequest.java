package com.example.backend.domain.recognition.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecognitionRequest {
    private String content;
}
