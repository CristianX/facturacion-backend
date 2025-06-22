package com.cristianx.backend_facturacion.consumer;

import com.cristianx.backend_facturacion.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FacturaConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirFacturaCreada(Long facturaId) {
        System.out.println("Mensaje recibido de la cola: Factura creada con ID: " + facturaId);
        // Aquí puedes agregar lógica adicional, como notificaciones, logs, etc.
    }
}
