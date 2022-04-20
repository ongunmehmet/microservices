package com.microserviceproject.repository;

import com.microserviceproject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


public interface TicketRepository extends JpaRepository<Ticket, String> {

}
