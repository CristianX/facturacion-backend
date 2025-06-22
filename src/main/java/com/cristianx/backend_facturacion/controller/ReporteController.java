package com.cristianx.backend_facturacion.controller;

import com.cristianx.backend_facturacion.models.Factura;
import com.cristianx.backend_facturacion.service.FacturaService;
import com.cristianx.backend_facturacion.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/facturas/pdf")
    public ResponseEntity<InputStreamResource> descargarReporteFacturas() {
        List<Factura> facturas = facturaService.findAll();
        InputStreamResource resource = new InputStreamResource(reporteService.generarReporteFacturas(facturas));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_facturas.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
