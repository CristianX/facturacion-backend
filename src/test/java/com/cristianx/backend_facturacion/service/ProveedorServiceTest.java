package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Proveedor;
import com.cristianx.backend_facturacion.repository.ProveedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProveedorServiceTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedorServiceImpl proveedorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(1L);
        proveedor1.setNombre("Proveedor A");
        Proveedor proveedor2 = new Proveedor();
        proveedor2.setId(2L);
        proveedor2.setNombre("Proveedor B");

        when(proveedorRepository.findAll()).thenReturn(Arrays.asList(proveedor1, proveedor2));

        List<Proveedor> proveedores = proveedorService.findAll();

        assertEquals(2, proveedores.size());
        assertEquals("Proveedor A", proveedores.get(0).getNombre());
        assertEquals("Proveedor B", proveedores.get(1).getNombre());
    }

    @Test
    void testFindById() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombre("Proveedor A");

        when(proveedorRepository.findById(1L)).thenReturn(Optional.of(proveedor));

        Optional<Proveedor> result = proveedorService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Proveedor A", result.get().getNombre());
    }

    @Test
    void testSave() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Nuevo Proveedor");

        when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

        Proveedor saved = proveedorService.save(proveedor);

        assertNotNull(saved);
        assertEquals("Nuevo Proveedor", saved.getNombre());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(proveedorRepository).deleteById(id);

        proveedorService.deleteById(id);

        verify(proveedorRepository, times(1)).deleteById(id);
    }
}
