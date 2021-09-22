package br.projeto.ecommerce.checkout.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@EntityListeners(AuditingEntityListener.class)
public class ShippingEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String address;

    @Column
    private String complement;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String cep;

    @OneToOne(mappedBy = "shipping")
    private CheckoutEntity checkout;
}
