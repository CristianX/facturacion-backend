package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Factura;
import com.cristianx.backend_facturacion.producer.FacturaProducer;
import com.cristianx.backend_facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaProducer facturaProducer;

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        Factura saved = facturaRepository.save(factura);
        facturaProducer.enviarFacturaCreada(saved);
        return saved;
    }

    @Override
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}
