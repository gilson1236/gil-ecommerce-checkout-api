package br.projeto.ecommerce.checkout.resource.checkout;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import br.projeto.ecommerce.checkout.entity.CheckoutEntity;
import br.projeto.ecommerce.checkout.service.CheckoutService;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;
    
    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest){
        final CheckoutEntity checkoutEntity =
                checkoutService.create(checkoutRequest).orElseThrow();
        final CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}
