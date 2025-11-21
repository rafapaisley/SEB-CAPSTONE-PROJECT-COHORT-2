package com.example.refundsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

    private String id;
    private double amount;
    private String currency;
    private String reason;
    private String status;
}
