package com.cristianx.backend_facturacion.producer;

import com.cristianx.backend_facturacion.config.RabbitMQConfig;
import com.cristianx.backend_facturacion.models.Factura;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacturaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarFacturaCreada(Factura factura) {
        // Puedes enviar el objeto completo o solo el ID, aquí enviamos el ID como
        // ejemplo
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                factura.getId());
    }
}
