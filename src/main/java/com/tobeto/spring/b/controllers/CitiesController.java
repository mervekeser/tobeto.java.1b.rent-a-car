package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.b.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.b.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.b.dtos.responses.city.GetCityResponse;
import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CitiesController {
    private final CityRepository cityRepository;

    public CitiesController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<GetCityListResponse> getAll(){
        List<City> cityList = cityRepository.findAll();
        List<GetCityListResponse> cityListResponses = new ArrayList<GetCityListResponse>();
        for (City city : cityList){
            GetCityListResponse cityListResponse = new GetCityListResponse();
            cityListResponse.setName(city.getName());

            cityListResponses.add(cityListResponse);
        }
        return cityListResponses;
    }

    @GetMapping({"id"})
    public GetCityResponse getById(@PathVariable int id){
        City city = cityRepository.findById(id).orElseThrow();

        GetCityResponse dto = new GetCityResponse();
        dto.setName(city.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCityRequest addCityRequest){
        City city = new City();

        city.setName(addCityRequest.getName());

        cityRepository.save(city);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCityRequest updateCityRequest){
        City cityToUpdate = cityRepository.findById(id).orElseThrow();

        cityToUpdate.setName(updateCityRequest.getName());

        cityRepository.save(cityToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        City cityToDelete = cityRepository.findById(id).orElseThrow();
        cityRepository.delete(cityToDelete);
    }
}
