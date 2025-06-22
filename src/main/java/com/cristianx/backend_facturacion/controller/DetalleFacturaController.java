package com.cristianx.backend_facturacion.controller;

import com.cristianx.backend_facturacion.models.DetalleFactura;
import com.cristianx.backend_facturacion.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-factura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping
    public List<DetalleFactura> getAllDetallesFactura() {
        return detalleFacturaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> getDetalleFacturaById(@PathVariable Long id) {
        Optional<DetalleFactura> detalle = detalleFacturaService.findById(id);
        return detalle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleFactura createDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.save(detalleFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> updateDetalleFactura(@PathVariable Long id,
            @RequestBody DetalleFactura detalleFactura) {
        Optional<DetalleFactura> existing = detalleFacturaService.findById(id);
        if (existing.isPresent()) {
            detalleFactura.setId(id);
            return ResponseEntity.ok(detalleFacturaService.save(detalleFactura));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleFactura(@PathVariable Long id) {
        if (detalleFacturaService.findById(id).isPresent()) {
            detalleFacturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
