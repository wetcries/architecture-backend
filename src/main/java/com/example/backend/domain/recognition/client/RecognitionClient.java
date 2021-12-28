package com.example.backend.domain.recognition.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Клиент для работы с сервисом распознавания автомобилей по фотографии.
 */
@FeignClient(value = "MlClient", url = "${ml-server-url}")
public interface RecognitionClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String helloWorld();

    @RequestMapping(method = RequestMethod.POST, value = "/recognition")
    RecognitionResponse recognition(RecognitionRequest request);
}
