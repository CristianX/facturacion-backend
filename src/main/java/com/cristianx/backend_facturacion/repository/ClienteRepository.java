package com.cristianx.backend_facturacion.repository;

import com.cristianx.backend_facturacion.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}