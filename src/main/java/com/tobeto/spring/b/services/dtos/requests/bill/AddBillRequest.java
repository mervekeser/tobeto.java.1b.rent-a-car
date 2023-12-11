package com.tobeto.spring.b.services.dtos.requests.bill;

import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillRequest {
    private LocalDate date;

    @PastOrPresent(message = "Kiralama süresi boş geçilemez")
    private String timeRent;

    private double price;
}
