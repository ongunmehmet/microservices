package com.microserviceproject.service;

import com.microserviceapp.messaging.TicketNotification;
import com.microserviceproject.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class StandartTicketNotificationService implements TicketNotificationService{

    @Override

    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification =new TicketNotification();
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketDescription(ticket.getDescription());


    }
}
