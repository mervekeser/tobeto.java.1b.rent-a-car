package com.tobeto.spring.b.services.dtos.responses.car;

import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
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

    private GetBrandListResponse brand;
}
