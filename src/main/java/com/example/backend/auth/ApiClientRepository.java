package com.example.backend.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiClientRepository extends CrudRepository<ApiClient, String> {
}
