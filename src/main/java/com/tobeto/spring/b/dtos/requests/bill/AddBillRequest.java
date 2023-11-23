package com.tobeto.spring.b.dtos.requests.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillRequest {
    private LocalDate date;

    private String timeRent;

    private double price;
}
