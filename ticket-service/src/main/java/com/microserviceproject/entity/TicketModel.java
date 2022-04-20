package com.microserviceproject.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.io.Serializable;
import java.util.Date;
@Data
@Builder
@EqualsAndHashCode(of ={"id"})
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "ticket")
public class TicketModel implements Serializable {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Text)
    private String notes;
    @Field(type = FieldType.Text)
    private String assignee;
    @Field(type = FieldType.Date)
    private Date ticketDate;
    @Field(type = FieldType.Text)
    private String priortiyType;
    @Field(type = FieldType.Text)
    private String ticketStatus;

}
