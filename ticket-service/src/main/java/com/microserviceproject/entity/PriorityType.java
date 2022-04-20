package com.microserviceproject.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"),LOW("Düşük"),HIGH("Yüksek");

    private String label;
    PriorityType(String label){
        this.label= label;
    }
}
