package com.example.eatikapi.repository;

import com.example.eatikapi.KategoriMenu;
import com.example.eatikapi.StatusMenu;
import com.example.eatikapi.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m WHERE " +
            "(:nama IS NULL OR LOWER(m.nama) LIKE LOWER(CONCAT('%', :nama, '%'))) AND " +
            "(:kategori IS NULL OR m.kategori = :kategori) AND " +
            "(:status IS NULL OR m.status = :status) AND " +
            "(:minHarga IS NULL OR m.harga >= :minHarga) AND " +
            "(:maxHarga IS NULL OR m.harga <= :maxHarga)")
    List<Menu> searchAndFilterMenu(
            @Param("nama") String nama,
            @Param("kategori") KategoriMenu kategori,
            @Param("status") StatusMenu status,
            @Param("minHarga") Double minHarga,
            @Param("maxHarga") Double maxHarga
    );
}
