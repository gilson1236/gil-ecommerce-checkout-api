package br.projeto.ecommerce.checkout.service;

import br.projeto.ecommerce.checkout.entity.CheckoutEntity;
import br.projeto.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
