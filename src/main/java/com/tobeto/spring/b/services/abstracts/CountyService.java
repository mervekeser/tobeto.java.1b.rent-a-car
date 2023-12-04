package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyListReponse;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyResponse;

import java.util.List;

public interface CountyService {
    List<GetCountyListReponse> getAll();
    GetCountyResponse getById(int id);
    void add(AddCountyRequest addCountyRequest);
    void update(UpdateCountyRequest updateCountyRequest, int id);
    void delete(int id);
}
