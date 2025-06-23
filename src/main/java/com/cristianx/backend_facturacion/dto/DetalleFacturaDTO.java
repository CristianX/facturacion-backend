package com.cristianx.backend_facturacion.dto;

public class DetalleFacturaDTO {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;

    // Constructores
    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(Long id, Long productoId, Integer cantidad, Double precioUnitario, Double total) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
