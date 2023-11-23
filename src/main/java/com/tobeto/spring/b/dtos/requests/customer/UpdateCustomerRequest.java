package com.tobeto.spring.b.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private int id;

    private String name;

    private String surname;

    private String identityNumber;

    private String phone;
}
