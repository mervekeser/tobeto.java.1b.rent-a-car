package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void add(AddCarRequest addCarRequest);
    void update(UpdateCarRequest updateCarRequest, int id);
    void delete(int id);
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    List<GetCarListResponse> getByModelName(String modelName);

    /*Optional<List<Car>> getByModelNameOrBrandId(String model_name, int brand_id);

    Optional<List<Car>> getBrandId (List<Integer> brands);

    Optional<List<Car>> getByModelNameContains(String model_name);

    Optional<List<Car>> getByModelNameStartsWith(String model_name);

    Optional<List<Car>> getByNameAndBrand(String name, int brand_id);*/
}
