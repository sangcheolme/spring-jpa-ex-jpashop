package jpabook.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter @Setter
@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private Address address;
    private DeliveryStatus status; // READY, COMP

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
}
