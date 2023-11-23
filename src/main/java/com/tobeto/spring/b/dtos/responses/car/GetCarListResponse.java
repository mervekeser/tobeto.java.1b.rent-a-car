package com.tobeto.spring.b.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int modelYear;

    private String modelName;

    private String color;

    private double price;
}
