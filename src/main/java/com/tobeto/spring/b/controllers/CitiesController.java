package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.CityService;
import com.tobeto.spring.b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityResponse;
import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CitiesController {
    private final CityService cityService;

    @PostMapping
    public void add(@RequestBody AddCityRequest addCityRequest){
        this.cityService.add(addCityRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCityRequest updateCityRequest){
        this.cityService.update(updateCityRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.cityService.delete(id);
    }

    @GetMapping
    public List<GetCityListResponse> getAll(){
        return this.cityService.getAll();
    }

    @GetMapping({"id"})
    public GetCityResponse getById(@PathVariable int id){
        return this.cityService.getById(id);
    }

    @GetMapping({"getByAll"})
    public List<GetCityListResponse> getByAll(){
        return this.cityService.getByAll();
    }
}
