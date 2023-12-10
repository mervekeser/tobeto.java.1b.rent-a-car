package com.tobeto.spring.b.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCarResponse {
    private int modelYear;

    private String modelName;

    private String color;

    private double price;
}
