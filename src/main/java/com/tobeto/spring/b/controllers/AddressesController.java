package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.entities.County;
import com.tobeto.spring.b.services.abstracts.AddressService;
import com.tobeto.spring.b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
@AllArgsConstructor
public class AddressesController {
    private final AddressService addressService;

    @PostMapping
    public void add(@RequestBody AddAddressRequest addressRequest){
        this.addressService.add(addressRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateAddressRequest updateAddressRequest){
        this.addressService.update(updateAddressRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.addressService.delete(id);
    }

    @GetMapping
    public List<GetAddressListResponse> getAll(){
        return this.addressService.getAll();
    }

    @GetMapping({"id"})
    public GetAddressResponse getById(@PathVariable int id){
        return this.addressService.getById(id);
    }

    @GetMapping("search")
    public GetAddressListResponse search(@RequestParam String addressText){
        return this.addressService.search(addressText);
    }

}
