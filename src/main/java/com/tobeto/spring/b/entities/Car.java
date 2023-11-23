package com.tobeto.spring.b.entities;

import jakarta.persistence.*;
import lombok.*;


@Table (name="cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model_year")
    private int modelYear;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    

}
