package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.city.GetCityListResponse(c.name, " +
            "new com.tobeto.spring.b.services.dtos.responses.county.GetCountyListReponse(co.name), " +
            "new com.tobeto.spring.b.services.dtos.responses.address.GetAddressListResponse(a.postalCode, a.addressText)) " +
            "FROM City c INNER JOIN c.counties co ON c.id = co.city.id " +
            "INNER JOIN c.addresses a ON c.id = a.city.id")
    List<GetCityListResponse> findByAll();
}