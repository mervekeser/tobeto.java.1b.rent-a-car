package com.tobeto.spring.b.services.dtos.requests.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    private LocalDate date;
    @NotBlank(message = "Kiralama başlangıç tarihi boş geçilemez")
    @Size(min=10, message = "Tarihi gün ay yıl olarak rakamlarla belirtin")
    private LocalDate startRent;
    @NotBlank(message = "Kiralama bitiş tarihi boş geçilemez")
    private LocalDate endRent;

    private double totalPrice;

    private String paymentType;
}
