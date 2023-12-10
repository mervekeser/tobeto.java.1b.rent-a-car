package com.tobeto.spring.b.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAddressResponse {
    private String postalCode;

    private String addressText;
}
