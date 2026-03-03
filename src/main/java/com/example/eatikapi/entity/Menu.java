package com.example.eatikapi.entity;

import com.example.eatikapi.KategoriMenu;
import com.example.eatikapi.StatusMenu;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false)
    private Double harga;

    @Column(nullable = true, length = 255)
    private String deskripsi;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KategoriMenu kategori;

    @Column(nullable = true)
    private String foto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusMenu status = StatusMenu.TERSEDIA;

    public Menu() {}

    public Menu(String nama, Double harga, String deskripsi, KategoriMenu kategori) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.status = StatusMenu.TERSEDIA;
    }

    public Long getId() {
        return id;
    }

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public StatusMenu getStatus() {
        return status;
    }

    public void setStatus(StatusMenu status) {
        this.status = status;
    }
}