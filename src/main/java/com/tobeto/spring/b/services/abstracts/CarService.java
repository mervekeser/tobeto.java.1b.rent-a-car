package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest addCarRequest);
    GetCarResponse getById(int id);
    List<GetCarListResponse> getAll();
    void update(UpdateCarRequest updateCarRequest, int id);
    void delete(int id);

}
