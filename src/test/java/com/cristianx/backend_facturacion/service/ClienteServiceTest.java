package com.cristianx.backend_facturacion.service;

import com.cristianx.backend_facturacion.models.Cliente;
import com.cristianx.backend_facturacion.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNombre("Juan");
        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNombre("Ana");

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.findAll();

        assertEquals(2, clientes.size());
        assertEquals("Juan", clientes.get(0).getNombre());
        assertEquals("Ana", clientes.get(1).getNombre());
    }

    @Test
    void testFindById() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
    }

    @Test
    void testSave() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Nuevo Cliente");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente saved = clienteService.save(cliente);

        assertNotNull(saved);
        assertEquals("Nuevo Cliente", saved.getNombre());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.deleteById(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }
}
