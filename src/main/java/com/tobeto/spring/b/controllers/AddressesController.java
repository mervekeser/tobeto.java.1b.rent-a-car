package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

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
    public List<Address> getAll(){return addressRepository.findAll();}

    @GetMapping({"id"})
    public Address getById(@PathVariable int id){
        return addressRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Address address){
        addressRepository.save(address);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Address address){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setId(address.getId());
        addressToUpdate.setPostalCode(address.getPostalCode());
        addressToUpdate.setAddressText(address.getAddressText());
        addressRepository.save(addressToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Address addressToDelete = addressRepository.findById(id).orElseThrow();
        addressRepository.delete(addressToDelete);
    }
}
