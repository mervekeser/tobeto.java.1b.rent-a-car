package com.tobeto.spring.b.services.dtos.responses.city;

import com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressResponse;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyListReponse;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCityListResponse {
    private String name;
    private GetCountyListReponse county;
    private GetAddressListResponse address;
}
