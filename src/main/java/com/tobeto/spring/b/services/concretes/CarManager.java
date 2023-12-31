package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public void add(AddCarRequest addCarRequest) {

        Car car = new Car();

        car.setModelYear(addCarRequest.getModelYear());
        car.setModelName(addCarRequest.getModelName());
        car.setColor(addCarRequest.getColor());
        car.setPrice(addCarRequest.getPrice());

        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest, int id) {
        Car carToUpdate = carRepository.findById(id).orElseThrow();

        carToUpdate.setModelYear(updateCarRequest.getModelYear());
        carToUpdate.setModelName(updateCarRequest.getModelName());
        carToUpdate.setColor(updateCarRequest.getColor());
        carToUpdate.setPrice(updateCarRequest.getPrice());

        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> carListResponses = new ArrayList<>();
        for (Car car: carList) {
            GetCarListResponse carListResponse = new GetCarListResponse();
            carListResponse.setModelYear(car.getModelYear());
            carListResponse.setModelName(car.getModelName());
            carListResponse.setColor(car.getColor());
            carListResponse.setPrice(car.getPrice());

            carListResponses.add(carListResponse);
        }
        return carListResponses;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        return GetCarResponse.builder()
                .modelName(car.getModelName())
                .modelYear(car.getModelYear())
                .color(car.getColor())
                .price(car.getPrice())
                .build();

    }

    //TODO 80.satırda exception handler kullanılacak
    @Override
    public List<GetCarListResponse> getByModelName(String modelName) {
        return this.carRepository.findByModelName(modelName);

    }

    /*@Override
    public Optional<List<Car>> getByModelNameOrBrandId(String model_name, int brand_id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Car>> getBrandId(List<Integer> brands) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Car>> getByModelNameContains(String model_name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Car>> getByModelNameStartsWith(String model_name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Car>> getByNameAndBrand(String name, int brand_id) {
        return Optional.empty();
    }*/
}
