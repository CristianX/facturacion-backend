package com.cristianx.backend_facturacion.repository;

import com.cristianx.backend_facturacion.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
