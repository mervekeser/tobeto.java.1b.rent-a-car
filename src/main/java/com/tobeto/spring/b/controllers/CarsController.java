package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest){
        this.carService.add(addCarRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.carService.delete(id);
    }

    @GetMapping
    public List<GetCarListResponse> getAll(){
        return this.carService.getAll();
    }

    @GetMapping({"id"})
    public GetCarResponse getById(@PathVariable int id){
        return this.carService.getById(id);
    }

    @GetMapping({"modelName"})
    public List<GetCarListResponse> getByModelName(@RequestParam String modelName){
        return this.carService.getByModelName(modelName);
    }


}
