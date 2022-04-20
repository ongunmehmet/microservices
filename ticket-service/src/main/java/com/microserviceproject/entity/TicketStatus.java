package com.microserviceproject.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("ÜZerinde Çalışılıyor"),
    RESOLVED("Çözüldü"),CLOSED("Kapandı");


    private String label;
    TicketStatus(String label){
        this.label= label;
    }
}
