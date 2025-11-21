package com.example.refundsapi.controller;

import com.example.refundsapi.model.Refund;
import com.example.refundsapi.model.RefundCreateRequest;
import com.example.refundsapi.model.RefundStatusRequest;
import com.example.refundsapi.service.RefundService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refunds")
public class RefundController {

    @Autowired
    private RefundService service;

    @GetMapping
    public List<Refund> getAllRefunds() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Refund> createRefund(@RequestBody RefundCreateRequest req) {
        return ResponseEntity.status(201).body(service.createRefund(req));
    }

    @GetMapping("/{id}")
    public Refund getRefundById(@PathVariable String id) {
        return service.getRefund(id);
    }

    @PostMapping("/status")
    public Refund getStatus(@RequestBody RefundStatusRequest req) {
        return service.checkStatus(req.getRefundId());
    }
}
