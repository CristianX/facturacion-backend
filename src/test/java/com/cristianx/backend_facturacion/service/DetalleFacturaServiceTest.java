package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.DetalleFactura;
import com.cristianx.backend_facturacion.repository.DetalleFacturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DetalleFacturaServiceTest {

    @Mock
    private DetalleFacturaRepository detalleFacturaRepository;

    @InjectMocks
    private DetalleFacturaServiceImpl detalleFacturaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        DetalleFactura detalle1 = new DetalleFactura();
        detalle1.setId(1L);
        DetalleFactura detalle2 = new DetalleFactura();
        detalle2.setId(2L);

        when(detalleFacturaRepository.findAll()).thenReturn(Arrays.asList(detalle1, detalle2));

        List<DetalleFactura> detalles = detalleFacturaService.findAll();

        assertEquals(2, detalles.size());
        assertEquals(1L, detalles.get(0).getId());
        assertEquals(2L, detalles.get(1).getId());
    }

    @Test
    void testFindById() {
        DetalleFactura detalle = new DetalleFactura();
        detalle.setId(1L);

        when(detalleFacturaRepository.findById(1L)).thenReturn(Optional.of(detalle));

        Optional<DetalleFactura> result = detalleFacturaService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        DetalleFactura detalle = new DetalleFactura();
        detalle.setId(1L);

        when(detalleFacturaRepository.save(detalle)).thenReturn(detalle);

        DetalleFactura saved = detalleFacturaService.save(detalle);

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(detalleFacturaRepository).deleteById(id);

        detalleFacturaService.deleteById(id);

        verify(detalleFacturaRepository, times(1)).deleteById(id);
    }
}
