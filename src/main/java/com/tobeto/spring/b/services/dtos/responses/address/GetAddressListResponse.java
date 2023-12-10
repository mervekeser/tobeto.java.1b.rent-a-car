package com.tobeto.spring.b.services.dtos.responses.address;

import com.tobeto.spring.b.entities.Address;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAddressListResponse {
    private String postalCode;

    private String addressText;
}