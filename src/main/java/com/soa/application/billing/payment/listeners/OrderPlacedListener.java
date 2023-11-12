package com.soa.application.billing.payment.listeners;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.soa.application.billing.payment.CollectPayment;
import com.soa.application.billing.payment.ReferenceId;
import com.soa.application.common.primitives.Money;
import com.soa.application.sales.order.OrderPlaced;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Component("payment-orderPlacedListener") 
@RequiredArgsConstructor
class OrderPlacedListener {

    private final @NonNull CollectPayment collectPayment;

    @TransactionalEventListener
    @Async
    public void on(OrderPlaced event) {
        collectPayment.collect(
                new ReferenceId(event.orderId),
                new Money(event.total));
    }
}
