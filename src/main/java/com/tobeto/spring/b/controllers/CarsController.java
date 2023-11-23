package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @GetMapping
    public List<GetCarListResponse> getAll(){
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> carListResponses = new ArrayList<GetCarListResponse>();
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

    @GetMapping({"id"})
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setModelName(car.getModelName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest){
        Car car = new Car();

        car.setModelYear(addCarRequest.getModelYear());
        car.setModelName(addCarRequest.getModelName());
        car.setColor(addCarRequest.getColor());
        car.setPrice(addCarRequest.getPrice());

        carRepository.save(car);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest){
        Car carToUpdate = carRepository.findById(id).orElseThrow();

        carToUpdate.setModelYear(updateCarRequest.getModelYear());
        carToUpdate.setModelName(updateCarRequest.getModelName());
        carToUpdate.setColor(updateCarRequest.getColor());
        carToUpdate.setPrice(updateCarRequest.getPrice());

        carRepository.save(carToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();

        carRepository.delete(carToDelete);
    }
}
