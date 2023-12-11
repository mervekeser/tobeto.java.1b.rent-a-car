package com.tobeto.spring.b.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    @Size(min = 5, max=5, message = "Posta kodu 5 haneli olmak zorunda")
    private String postalCode;
    @NotBlank(message = "Adres formatı: mah. cad. no.")
    private String addressText;
}
