package com.cristianx.backend_facturacion.repository;

import com.cristianx.backend_facturacion.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
