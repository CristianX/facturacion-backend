package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.DetalleFactura;
import com.cristianx.backend_facturacion.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> findAll() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public Optional<DetalleFactura> findById(Long id) {
        return detalleFacturaRepository.findById(id);
    }

    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    @Override
    public void deleteById(Long id) {
        detalleFacturaRepository.deleteById(id);
    }
}
