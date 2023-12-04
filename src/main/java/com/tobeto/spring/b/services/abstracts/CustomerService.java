package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getbyId(int id);
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest, int id);
    void delete(int id);
}
