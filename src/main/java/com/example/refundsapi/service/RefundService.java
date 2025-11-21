package com.example.refundsapi.service;

import com.example.refundsapi.model.Refund;
import com.example.refundsapi.model.RefundCreateRequest;
import com.example.refundsapi.model.RefundStatusRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RefundService {

    private final Map<String, Refund> store = new HashMap<>();

    public Refund createRefund(RefundCreateRequest req) {
        String id = UUID.randomUUID().toString();

        Refund refund = new Refund(
                id,
                req.getAmount(),
                req.getCurrency(),
                req.getReason(),
                "PENDING"
        );

        store.put(id, refund);
        return refund;
    }

    public Refund getRefund(String id) {
        return Optional.ofNullable(store.get(id))
                .orElseThrow(() -> new RuntimeException("Refund Not Found"));
    }

    public Refund checkStatus(String id) {
        return getRefund(id);
    }

    public List<Refund> getAll() {
        return new ArrayList<>(store.values());
    }
}
