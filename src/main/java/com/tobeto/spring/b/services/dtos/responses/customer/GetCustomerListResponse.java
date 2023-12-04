package com.tobeto.spring.b.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private String name;

    private String surname;

    private String identityNumber;

    private String phone;
}
