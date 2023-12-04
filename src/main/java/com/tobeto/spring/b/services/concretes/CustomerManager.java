package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import com.tobeto.spring.b.services.abstracts.CustomerService;
import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerListResponses = new ArrayList<>();
        for(Customer customer : customerList){
            GetCustomerListResponse getCustomerResponse = new GetCustomerListResponse();
            getCustomerResponse.setName(customer.getName());

            getCustomerListResponses.add(getCustomerResponse);
        }

        return getCustomerListResponses;
    }

    @Override
    public GetCustomerResponse getbyId(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        getCustomerResponse.setName(customer.getName());

        return getCustomerResponse;
    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(addCustomerRequest.getName());

        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest, int id) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setId(updateCustomerRequest.getId());
        customerToUpdate.setName(updateCustomerRequest.getName());
        customerToUpdate.setSurname(updateCustomerRequest.getSurname());
        customerToUpdate.setIdentityNumber(updateCustomerRequest.getIdentityNumber());
        customerToUpdate.setPhone(updateCustomerRequest.getPhone());

        customerRepository.save(customerToUpdate);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}