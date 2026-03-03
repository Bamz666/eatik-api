package com.example.eatikapi.dto;

import com.example.eatikapi.KategoriMenu;
import com.example.eatikapi.StatusMenu;

public class MenuRequest {

    private String nama;
    private Double harga;
    private String deskripsi;
    private KategoriMenu kategori;
    private StatusMenu status;

    public MenuRequest() {}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public KategoriMenu getKategori() {
        return kategori;
    }

    public void setKategori(KategoriMenu kategori) {
        this.kategori = kategori;
    }

    public StatusMenu getStatus() {
        return status;
    }

    public void setStatus(StatusMenu status) {
        this.status = status;
    }
}