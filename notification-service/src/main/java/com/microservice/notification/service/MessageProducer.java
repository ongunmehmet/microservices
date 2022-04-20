package com.microservice.notification.service;

import com.microserviceapp.messaging.TicketNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange exchange;

    @RabbitListener
    public void send(TicketNotification ticketNotification){
        rabbitTemplate.convertAndSend(exchange.getName(),ticketNotification.toString())
        ;
    }


}
