package com.soa.application.billing.payment.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.application.billing.payment.FindPayments;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
class PaymentController {

    private static final int MAX_RESULTS = 10;

    private final @NonNull FindPayments findPayments;

    @GetMapping
    public List<Map<String, ?>> all() {
        return findPayments.all().range(MAX_RESULTS).stream()
                .map(payment -> Map.of(
                        "id", payment.id().value(),
                        "referenceId", payment.referenceId().value(),
                        "total", payment.total().value(),
                        "collected", payment.isCollected()))
                .collect(Collectors.toList());
    }
}