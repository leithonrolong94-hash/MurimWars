package com.murimwars.murimwars.service;

import com.murimwars.murimwars.model.Producto;
import com.murimwars.murimwars.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Contiene las reglas de negocio para la administración del inventario.
 */
@Service
@Transactional
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el producto solicitado."));
    }

    public Producto guardar(Producto producto) {
        repository.findBySku(producto.getSku()).ifPresent(existente -> {
            if (producto.getId() == null || !existente.getId().equals(producto.getId())) {
                throw new IllegalArgumentException("Ya existe un producto con ese código SKU.");
            }
        });
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No existe el producto que intenta eliminar.");
        }
        repository.deleteById(id);
    }
}
