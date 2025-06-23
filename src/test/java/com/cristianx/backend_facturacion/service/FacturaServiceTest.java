package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Factura;
import com.cristianx.backend_facturacion.producer.FacturaProducer;
import com.cristianx.backend_facturacion.repository.FacturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacturaServiceTest {

    @Mock
    private FacturaRepository facturaRepository;

    @Mock
    private FacturaProducer facturaProducer;

    @InjectMocks
    private FacturaServiceImpl facturaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Factura factura1 = new Factura();
        factura1.setId(1L);
        factura1.setFecha(LocalDateTime.now());
        Factura factura2 = new Factura();
        factura2.setId(2L);
        factura2.setFecha(LocalDateTime.now());

        when(facturaRepository.findAll()).thenReturn(Arrays.asList(factura1, factura2));

        List<Factura> facturas = facturaService.findAll();

        assertEquals(2, facturas.size());
        assertEquals(1L, facturas.get(0).getId());
        assertEquals(2L, facturas.get(1).getId());
    }

    @Test
    void testFindById() {
        Factura factura = new Factura();
        factura.setId(1L);

        when(facturaRepository.findById(1L)).thenReturn(Optional.of(factura));

        Optional<Factura> result = facturaService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        Factura factura = new Factura();
        factura.setId(1L);

        when(facturaRepository.save(factura)).thenReturn(factura);

        Factura saved = facturaService.save(factura);

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(facturaRepository).deleteById(id);

        facturaService.deleteById(id);

        verify(facturaRepository, times(1)).deleteById(id);
    }
}
