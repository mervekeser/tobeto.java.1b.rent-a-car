package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import com.tobeto.spring.b.services.abstracts.CustomerService;
import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {
    private final CustomerService customerService;

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        this.customerService.add(addCustomerRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }

    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        return this.customerService.getAll();
    }

    @GetMapping({"id"})
    public GetCustomerResponse getById(@PathVariable int id){
       return this.customerService.getbyId(id);
    }

    @GetMapping({"identityNumber"})
    public List<GetCustomerListResponse> getByIdentityNumber(@RequestParam String identityNumber){
        return customerService.getByIdentityNumber(identityNumber);
    }
}
