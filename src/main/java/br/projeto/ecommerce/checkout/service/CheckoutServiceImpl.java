package br.projeto.ecommerce.checkout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import br.projeto.ecommerce.checkout.entity.CheckoutEntity;
import br.projeto.ecommerce.checkout.resource.checkout.CheckoutRequest;
import br.projeto.ecommerce.checkout.repository.CheckoutRepository;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {

        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
