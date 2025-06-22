package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> findAll();

    Optional<Factura> findById(Long id);

    Factura save(Factura factura);

    void deleteById(Long id);
}
