package com.example.refundsapi.model;

import lombok.Data;

@Data
public class RefundCreateRequest {

    private double amount;
    private String currency;
    private String reason;
}
