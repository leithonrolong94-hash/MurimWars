package com.murimwars.murimwars.repository;

import com.murimwars.murimwars.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Acceso a datos de productos. Spring Data JPA implementa las operaciones CRUD.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findBySku(String sku);
    boolean existsBySkuAndIdNot(String sku, Long id);
}
