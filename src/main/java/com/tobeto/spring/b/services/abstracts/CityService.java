package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityResponse;

import java.util.List;

public interface CityService {
    void add(AddCityRequest addCityRequest);
    void update(UpdateCityRequest updateCityRequest, int id);
    void delete(int id);
    List<GetCityListResponse> getAll();
    GetCityResponse getById(int id);
    List<GetCityListResponse> getByAll();
}
