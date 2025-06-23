package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Producto;
import com.cristianx.backend_facturacion.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Producto A");
        Producto producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Producto B");

        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoService.findAll();

        assertEquals(2, productos.size());
        assertEquals("Producto A", productos.get(0).getNombre());
        assertEquals("Producto B", productos.get(1).getNombre());
    }

    @Test
    void testFindById() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto A");

        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> result = productoService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Producto A", result.get().getNombre());
    }

    @Test
    void testSave() {
        Producto producto = new Producto();
        producto.setNombre("Nuevo Producto");

        when(productoRepository.save(producto)).thenReturn(producto);

        Producto saved = productoService.save(producto);

        assertNotNull(saved);
        assertEquals("Nuevo Producto", saved.getNombre());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(productoRepository).deleteById(id);

        productoService.deleteById(id);

        verify(productoRepository, times(1)).deleteById(id);
    }
}
