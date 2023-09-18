package com.desanlesr95.pizzeria.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer",nullable = false)
    private Integer idCustomer;

    @Column(nullable = false,length = 60)
    private String name;

    @Column(nullable = false,length = 100)
    private String address;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false,length = 20,name = "phone_number")
    private String phoneNumber;
}
