package com.tobeto.spring.b.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
   private int id;

    private int modelYear;

    private String modelName;

    private String color;

    private double price;
}
