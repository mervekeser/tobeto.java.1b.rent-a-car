package com.tobeto.spring.b.dtos.requests.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    private String name;
}
