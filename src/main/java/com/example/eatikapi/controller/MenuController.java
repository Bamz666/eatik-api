package com.example.eatikapi.controller;

import com.example.eatikapi.dto.MenuRequest;
import com.example.eatikapi.dto.MenuResponse;
import com.example.eatikapi.KategoriMenu;
import com.example.eatikapi.StatusMenu;
import com.example.eatikapi.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<MenuResponse> getAllMenu(
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) KategoriMenu kategori,
            @RequestParam(required = false) StatusMenu status,
            @RequestParam(required = false) Double minHarga,
            @RequestParam(required = false) Double maxHarga
    ) {
        return menuService.getAllMenu(nama, kategori, status, minHarga, maxHarga);
    }

    @PostMapping(consumes = "multipart/form-data")
    public MenuResponse createMenu(
            @RequestParam String nama,
            @RequestParam Double harga,
            @RequestParam(required = false) String deskripsi,
            @RequestParam KategoriMenu kategori,
            @RequestParam(required = false) StatusMenu status,
            @RequestParam(required = false) MultipartFile foto
    ) throws IOException {

        String fileName = null;

        if (foto != null && !foto.isEmpty()) {

            fileName = UUID.randomUUID() + "_" + foto.getOriginalFilename();

            String projectPath = System.getProperty("user.dir");
            String uploadDir = projectPath + "/uploads/";

            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            File destination = new File(uploadDir + fileName);
            foto.transferTo(destination);
        }

        MenuRequest request = new MenuRequest();
        request.setNama(nama);
        request.setHarga(harga);
        request.setDeskripsi(deskripsi);
        request.setKategori(kategori);
        request.setStatus(status);

        return menuService.saveMenu(request, fileName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}