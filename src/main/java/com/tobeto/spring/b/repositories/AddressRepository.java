package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository <Address, Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse(a.addressText, a.postalCode) FROM Address a " +
            "WHERE a.addressText = :addressText")
    GetAddressListResponse search(String addressText);

}
