package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

  /*  @ManyToMany(mappedBy = "customers")
    private List<Address> addresses; */

    @OneToMany(mappedBy = "customer")
    private List<Bill> bills;


}
