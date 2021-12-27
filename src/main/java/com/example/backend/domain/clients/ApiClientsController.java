package com.example.backend.domain.clients;

import com.example.backend.auth.ApiClientService;
import com.example.backend.security.jwt.UsernameAndPasswordAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ApiClientsController {
    private final ApiClientService apiClientService;

    @Autowired
    public ApiClientsController(ApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    @PostMapping
    public void createNewClient(@RequestBody UsernameAndPasswordAuthenticationRequest usernameAndPassword) {
        apiClientService.createClient(usernameAndPassword.getUsername(), usernameAndPassword.getPassword());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Username exists")
    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgument() {
    }
}
