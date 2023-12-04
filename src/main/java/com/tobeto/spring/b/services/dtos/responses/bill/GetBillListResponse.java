package com.tobeto.spring.b.services.dtos.responses.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBillListResponse {
    private LocalDate date;

    private String timeRent;

    private double price;
}
