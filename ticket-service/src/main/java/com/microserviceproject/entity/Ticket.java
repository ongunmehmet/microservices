package com.microserviceproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket  extends  BaseModel{
    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Getter
    @Setter
    @Column(name = "description",length = 600)
    private String description;
    @Getter
    @Setter
    @Column(name = "notes",length = 4000)
    private String notes;
    @Getter
    @Setter
    @Column(name = "assigneen",length = 50)
    private String assignee;
    @Getter
    @Setter
    @Column(name = "ticket_date")
    private Date ticketDate;
    @Getter
    @Setter
    @Enumerated
    @Column(name = "priority_type")
    private PriorityType priorityType;
    @Getter
    @Setter
    @Enumerated
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;
}
