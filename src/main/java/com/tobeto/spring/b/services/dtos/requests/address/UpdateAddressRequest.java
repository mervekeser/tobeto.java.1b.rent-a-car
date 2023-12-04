package com.tobeto.spring.b.services.dtos.requests.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    private int id;

    private String postalCode;

    private String addressText;


}
