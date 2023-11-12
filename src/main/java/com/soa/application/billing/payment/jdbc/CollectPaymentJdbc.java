package com.soa.application.billing.payment.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soa.application.billing.payment.CollectPayment;
import com.soa.application.billing.payment.Payment;
import com.soa.application.billing.payment.ReferenceId;
import com.soa.application.common.events.EventPublisher;
import com.soa.application.common.primitives.Money;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
class CollectPaymentJdbc implements CollectPayment {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void collect(ReferenceId referenceId, Money total) {
        Payment payment = new PaymentJdbc(referenceId, total, jdbcTemplate, eventPublisher);
        payment.request();


        payment.collect();
    }
}
