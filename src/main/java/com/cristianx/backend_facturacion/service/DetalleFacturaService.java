package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface DetalleFacturaService {
    List<DetalleFactura> findAll();
    Optional<DetalleFactura> findById(Long id);
    DetalleFactura save(DetalleFactura detalleFactura);
    void deleteById(Long id);
}
