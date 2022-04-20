package com.microserviceproject.service;

import com.microserviceproject.entity.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
