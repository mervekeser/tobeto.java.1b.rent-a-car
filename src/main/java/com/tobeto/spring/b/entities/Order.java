package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
