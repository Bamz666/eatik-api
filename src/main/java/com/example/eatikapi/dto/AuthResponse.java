package com.example.eatikapi.dto;

public class AuthResponse {
    private String message;
    private String username;
    private String nama;

    public AuthResponse(String message, String username, String nama) {
        this.message = message;
        this.username = username;
        this.nama = nama;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}
