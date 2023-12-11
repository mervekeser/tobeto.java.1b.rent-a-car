package com.tobeto.spring.b.services.dtos.requests.city;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    @Size(min= 3, message = "Şehir ismini doğru girdiğinizden emin olun")
    private String name;
}
