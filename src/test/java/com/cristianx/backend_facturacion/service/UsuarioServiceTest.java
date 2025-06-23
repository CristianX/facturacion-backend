package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Usuario;
import com.cristianx.backend_facturacion.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNombreUsuario("admin");
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombreUsuario("user");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> usuarios = usuarioService.findAll();

        assertEquals(2, usuarios.size());
        assertEquals("admin", usuarios.get(0).getNombreUsuario());
        assertEquals("user", usuarios.get(1).getNombreUsuario());
    }

    @Test
    void testFindById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombreUsuario("admin");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("admin", result.get().getNombreUsuario());
    }

    @Test
    void testFindByNombreUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombreUsuario("admin");

        when(usuarioRepository.findByNombreUsuario("admin")).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.findByNombreUsuario("admin");

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("nuevo_usuario");

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario saved = usuarioService.save(usuario);

        assertNotNull(saved);
        assertEquals("nuevo_usuario", saved.getNombreUsuario());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(usuarioRepository).deleteById(id);

        usuarioService.deleteById(id);

        verify(usuarioRepository, times(1)).deleteById(id);
    }
}
