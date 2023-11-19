package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_rent")
    private LocalDate startRent;

    @Column(name = "end_rent")
    private LocalDate endRent;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToMany(mappedBy = "order")
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

   /* @OneToOne(mappedBy = "order")
    private Bill bill; */
}
