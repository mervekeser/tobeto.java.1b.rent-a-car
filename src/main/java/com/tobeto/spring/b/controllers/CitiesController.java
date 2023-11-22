package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CitiesController {
    private final CityRepository cityRepository;

    public CitiesController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAll(){return cityRepository.findAll();}

    @GetMapping({"id"})
    public City getById(@PathVariable int id){
        return cityRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody City city){
        cityRepository.save(city);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody City city){
        City cityToUpdate = cityRepository.findById(id).orElseThrow();
        cityToUpdate.setId(city.getId());
        cityToUpdate.setName(city.getName());
        cityRepository.save(cityToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        City cityToDelete = cityRepository.findById(id).orElseThrow();
        cityRepository.delete(cityToDelete);
    }
}
