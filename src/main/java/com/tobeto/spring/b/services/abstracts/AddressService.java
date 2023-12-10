package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressResponse;

import java.util.List;

public interface AddressService {
    void add(AddAddressRequest addAddressRequest);
    void update(UpdateAddressRequest updateAddressRequest, int id);
    void delete(int id);
    List<GetAddressListResponse> getAll();
    GetAddressResponse getById(int id);

    GetAddressListResponse search(String addressText);

}
