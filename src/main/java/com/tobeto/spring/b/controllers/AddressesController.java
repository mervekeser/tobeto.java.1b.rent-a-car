package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.b.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.b.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.b.dtos.responses.address.GetAddressResponse;
import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/addresses")
public class AddressesController {
    private final AddressRepository addressRepository;
    public AddressesController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<GetAddressListResponse> getAll(){
        List<Address> addressList = addressRepository.findAll();
        List<GetAddressListResponse> addressListResponses = new ArrayList<GetAddressListResponse>();
        for(Address address : addressList){
            GetAddressListResponse addressListResponse = new GetAddressListResponse();
            addressListResponse.setPostalCode(address.getPostalCode());
            addressListResponse.setAddressText(address.getAddressText());

            addressListResponses.add(addressListResponse);
        }
        return addressListResponses;
    }

    @GetMapping({"id"})
    public GetAddressResponse getById(@PathVariable int id){
        Address address = addressRepository.findById(id).orElseThrow();

        GetAddressResponse dto = new GetAddressResponse();
        dto.setPostalCode(address.getPostalCode());
        dto.setAddressText(address.getAddressText());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest addressRequest){
        Address address = new Address();

        address.setPostalCode(addressRequest.getPostalCode());
        address.setAddressText(address.getAddressText());

        addressRepository.save(address);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateAddressRequest updateAddressRequest){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();

        addressToUpdate.setPostalCode(updateAddressRequest.getPostalCode());
        addressToUpdate.setAddressText(updateAddressRequest.getAddressText());
        addressRepository.save(addressToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Address addressToDelete = addressRepository.findById(id).orElseThrow();
        addressRepository.delete(addressToDelete);
    }
}
