package com.tobeto.spring.b.services.dtos.requests.car;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int modelYear;
    @NotEmpty(message = "Model ismini belirtilmesi zorunlu")
    private String modelName;

    private String color;

    private double price;


}
