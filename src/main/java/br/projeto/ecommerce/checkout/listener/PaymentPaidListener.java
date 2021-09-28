package br.projeto.ecommerce.checkout.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import br.projeto.ecommerce.checkout.entity.CheckoutEntity;
import br.projeto.ecommerce.checkout.service.CheckoutService;
import br.projeto.ecommerce.payment.event.PaymentCreatedEvent;
import br.projeto.ecommerce.checkout.streaming.PaymentPaidSink;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent){
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(),
                CheckoutEntity.Status.APPROVED);
    }
}
