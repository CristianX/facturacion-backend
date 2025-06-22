package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
