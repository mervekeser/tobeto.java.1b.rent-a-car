package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.City;
import com.tobeto.spring.b.repositories.CityRepository;
import com.tobeto.spring.b.services.abstracts.CityService;
import com.tobeto.spring.b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.b.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CityManager implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<GetCityListResponse> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<GetCityListResponse> cityListResponses = new ArrayList<GetCityListResponse>();
        for (City city : cityList){
            GetCityListResponse cityListResponse = new GetCityListResponse();
            cityListResponse.setName(city.getName());

            cityListResponses.add(cityListResponse);
        }
        return cityListResponses;
    }


    @Override
    public GetCityResponse getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();

        GetCityResponse getCityResponse = new GetCityResponse();
        getCityResponse.setName(city.getName());
        return getCityResponse;
    }

    @Override
    public void add(AddCityRequest addCityRequest) {
        City city = new City();

        city.setName(addCityRequest.getName());

        cityRepository.save(city);
    }

    @Override
    public void update(UpdateCityRequest updateCityRequest, int id) {
        City cityToUpdate = cityRepository.findById(id).orElseThrow();

        cityToUpdate.setName(updateCityRequest.getName());

        cityRepository.save(cityToUpdate);
    }


    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }
}
