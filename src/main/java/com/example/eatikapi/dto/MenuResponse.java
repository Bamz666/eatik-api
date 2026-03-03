package com.example.eatikapi.dto;

import com.example.eatikapi.KategoriMenu;
import com.example.eatikapi.StatusMenu;

public class MenuResponse {

    private Long id;
    private String nama;
    private Double harga;
    private String deskripsi;
    private KategoriMenu kategori;
    private String foto;
    private StatusMenu status;

    public MenuResponse(
            Long id,
            String nama,
            Double harga,
            String deskripsi,
            KategoriMenu kategori,
            String foto,
            StatusMenu status
    ) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.foto = foto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Double getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public KategoriMenu getKategori() {
        return kategori;
    }

    public String getFoto() {
        return foto;
    }

    public StatusMenu getStatus() {
        return status;
    }
}