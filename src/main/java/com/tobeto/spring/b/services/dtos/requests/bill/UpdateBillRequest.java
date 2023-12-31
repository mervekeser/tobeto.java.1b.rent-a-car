package com.tobeto.spring.b.services.dtos.requests.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillRequest {
    private int id;

    private LocalDate date;

    private String timeRent;

    private double price;

}
