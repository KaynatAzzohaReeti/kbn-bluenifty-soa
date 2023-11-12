package com.soa.application.billing.payment.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.soa.application.common.events.EventPublisher;


@Configuration
class PaymentJdbcConfig {

    @Bean
    FindPaymentsJdbc findPaymentsJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher) {
        return new FindPaymentsJdbc(jdbcTemplate, eventPublisher);
    }

    @Bean
    CollectPaymentJdbc collectPaymentJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher) {
        return new CollectPaymentJdbc(jdbcTemplate, eventPublisher);
    }
}
