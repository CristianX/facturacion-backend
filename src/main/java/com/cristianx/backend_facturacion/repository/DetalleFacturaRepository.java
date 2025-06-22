package com.cristianx.backend_facturacion.repository;

import com.cristianx.backend_facturacion.models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {

}
