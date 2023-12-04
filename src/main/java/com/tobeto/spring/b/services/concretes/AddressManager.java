package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import com.tobeto.spring.b.services.abstracts.AddressService;
import com.tobeto.spring.b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public void add(AddAddressRequest addressRequest) {
        Address address = new Address();

        address.setPostalCode(addressRequest.getPostalCode());
        address.setAddressText(address.getAddressText());

        addressRepository.save(address);
    }

    @Override
    public List<GetAddressListResponse> getAll() {
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

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();

        GetAddressResponse getAddressResponse = new GetAddressResponse();
        getAddressResponse.setPostalCode(address.getPostalCode());
        getAddressResponse.setAddressText(address.getAddressText());

        return getAddressResponse;
    }

    @Override
    public void update(UpdateAddressRequest updateAddressRequest, int id) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();

        addressToUpdate.setPostalCode(updateAddressRequest.getPostalCode());
        addressToUpdate.setAddressText(updateAddressRequest.getAddressText());
        addressRepository.save(addressToUpdate);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
