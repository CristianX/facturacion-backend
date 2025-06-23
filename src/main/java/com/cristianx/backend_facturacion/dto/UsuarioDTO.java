package com.cristianx.backend_facturacion.dto;

public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String roles;

    // Constructores
    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nombreUsuario, String roles) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.roles = roles;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
