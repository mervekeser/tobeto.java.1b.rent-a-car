package com.tobeto.spring.b.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "counties")
public class County {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "county")
    private List<Address> addresses;


}
