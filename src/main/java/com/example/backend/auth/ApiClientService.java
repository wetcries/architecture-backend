package com.example.backend.auth;

import com.example.backend.security.ClientRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApiClientService implements UserDetailsService {
    private final ApiClientRepository apiClientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApiClientService(ApiClientRepository apiClientRepository, PasswordEncoder passwordEncoder) {
        this.apiClientRepository = apiClientRepository;
        this.passwordEncoder = passwordEncoder;

        initializeAdminIfNotExist();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return apiClientRepository.findById(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s was not found", username)));
    }

    public UserDetails createClient(String username, String password) {
        apiClientRepository.findById(username).ifPresent(apiClient -> {
            throw new IllegalStateException(String.format("Client with username %s exists", username));
        });
        ApiClient apiClient = new ApiClient(
                username,
                passwordEncoder.encode(password),
                ClientRole.CLIENT,
                true,
                true,
                true,
                true
        );
        return apiClientRepository.save(apiClient);
    }

    private void initializeAdminIfNotExist() {
        apiClientRepository.findById("admin").orElseGet(() -> {
            ApiClient admin = new ApiClient(
                    "admin",
                    passwordEncoder.encode("admin"),
                    ClientRole.ADMIN,
                    true,
                    true,
                    true,
                    true
            );
            return apiClientRepository.save(admin);
        });
    }
}
