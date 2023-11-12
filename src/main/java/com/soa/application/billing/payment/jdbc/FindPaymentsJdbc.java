package com.soa.application.billing.payment.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.soa.application.billing.payment.FindPayments;
import com.soa.application.billing.payment.Payments;
import com.soa.application.common.events.EventPublisher;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
final class FindPaymentsJdbc implements FindPayments {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Override
    public Payments all() {
        return new PaymentsJdbc(
                "SELECT id, reference_id referenceId, total, status FROM payments",
                jdbcTemplate, eventPublisher);
    }
}
