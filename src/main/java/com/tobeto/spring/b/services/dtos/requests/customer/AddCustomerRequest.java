package com.tobeto.spring.b.services.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = "isim boş geçilemez")
    private String name;
    @NotBlank(message = "soyisim boş geçilemez")
    private String surname;
    @Size(min=11, message = "Tc no kimlikle uyumlu olmalı")
    private String identityNumber;

    private String phone;
}
