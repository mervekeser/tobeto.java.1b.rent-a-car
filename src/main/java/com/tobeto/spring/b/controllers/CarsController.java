package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping({"id"})
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setId(car.getId());
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setModelName(car.getModelName());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setPrice(car.getPrice());
        carRepository.save(carToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}
