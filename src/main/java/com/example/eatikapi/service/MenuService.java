package com.example.eatikapi.service;

import com.example.eatikapi.dto.MenuRequest;
import com.example.eatikapi.dto.MenuResponse;
import com.example.eatikapi.entity.Menu;
import com.example.eatikapi.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuResponse> getAllMenu() {
        return menuRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public MenuResponse getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu tidak ditemukan"));

        return mapToResponse(menu);
    }

    public MenuResponse saveMenu(
            MenuRequest request,
            String fileName
    ) {

        Menu menu = new Menu();

        menu.setNama(request.getNama());
        menu.setHarga(request.getHarga());
        menu.setDeskripsi(request.getDeskripsi());
        menu.setKategori(request.getKategori());

        if (fileName != null) {
            menu.setFoto(fileName);
        }

        if (request.getStatus() != null) {
            menu.setStatus(request.getStatus());
        }

        Menu saved = menuRepository.save(menu);

        return mapToResponse(saved);
    }

    public void deleteMenu(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu tidak ditemukan"));

        if (menu.getFoto() != null) {
            deleteFile(menu.getFoto());
        }

        menuRepository.delete(menu);
    }

    private void deleteFile(String fileName) {

        String projectPath = System.getProperty("user.dir");
        String uploadDir = projectPath + "/uploads/";
        File file = new File(uploadDir + fileName);

        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) {
                System.out.println("Gagal menghapus file: " + fileName);
            }
        }
    }

    private MenuResponse mapToResponse(Menu menu) {
        return new MenuResponse(
                menu.getId(),
                menu.getNama(),
                menu.getHarga(),
                menu.getDeskripsi(),
                menu.getKategori(),
                menu.getFoto(),
                menu.getStatus()
        );
    }
}