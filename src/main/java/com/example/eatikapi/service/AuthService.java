package com.example.eatikapi.service;

import com.example.eatikapi.config.JwtProvider;
import com.example.eatikapi.dto.AuthResponse;
import com.example.eatikapi.dto.LoginRequest;
import com.example.eatikapi.dto.RegisterRequest;
import com.example.eatikapi.entity.User;
import com.example.eatikapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username sudah terdaftar!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNama(request.getNama());

        userRepository.save(user);

        return new AuthResponse("Registrasi berhasil", null, user.getUsername(), user.getNama());
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Username atau password salah!"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Username atau password salah!");
        }

        String token = jwtProvider.generateToken(user.getUsername());

        return new AuthResponse("Login berhasil", token, user.getUsername(), user.getNama());
    }
}
