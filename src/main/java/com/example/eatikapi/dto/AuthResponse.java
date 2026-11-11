package com.example.eatikapi.dto;

public class AuthResponse {
    private String message;
    private String token;
    private String username;
    private String nama;

    public AuthResponse(String message, String token, String username, String nama) {
        this.message = message;
        this.token = token;
        this.username = username;
        this.nama = nama;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}
