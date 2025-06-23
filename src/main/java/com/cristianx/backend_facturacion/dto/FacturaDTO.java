package com.cristianx.backend_facturacion.dto;

import java.time.LocalDateTime;
import java.util.List;

public class FacturaDTO {
    private Long id;
    private Long clienteId;
    private Long proveedorId;
    private LocalDateTime fecha;
    private Double subtotal;
    private Double iva;
    private Double total;
    private List<DetalleFacturaDTO> detalles;

    // Constructores
    public FacturaDTO() {}

    public FacturaDTO(Long id, Long clienteId, Long proveedorId, LocalDateTime fecha, Double subtotal, Double iva, Double total, List<DetalleFacturaDTO> detalles) {
        this.id = id;
        this.clienteId = clienteId;
        this.proveedorId = proveedorId;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.detalles = detalles;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getIva() { return iva; }
    public void setIva(Double iva) { this.iva = iva; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public List<DetalleFacturaDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleFacturaDTO> detalles) { this.detalles = detalles; }
}
