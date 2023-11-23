package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.b.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.b.dtos.responses.county.GetCountyListReponse;
import com.tobeto.spring.b.dtos.responses.county.GetCountyResponse;
import com.tobeto.spring.b.entities.County;
import com.tobeto.spring.b.repositories.CountyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/counties")
public class CountiesController {

    private final CountyRepository countyRepository;

    public CountiesController(CountyRepository countyRepository){
        this.countyRepository = countyRepository;
    }

    @GetMapping
    public List<GetCountyListReponse> getAll(){
        List<County> countyList = countyRepository.findAll();
        List<GetCountyListReponse> countyListReponses = new ArrayList<GetCountyListReponse>();
        for (County county : countyList){
            GetCountyListReponse countyListReponse = new GetCountyListReponse();
            countyListReponse.setName(county.getName());

            countyListReponses.add(countyListReponse);
        }
        return countyListReponses;
    }

    @GetMapping({"id"})
    public GetCountyResponse getById(@PathVariable int id){
        County county = countyRepository.findById(id).orElseThrow();

        GetCountyResponse dto = new GetCountyResponse();
        dto.setName(county.getName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCountyRequest addCountyRequest){
        County county = new County();

        county.setName(addCountyRequest.getName());

        countyRepository.save(county);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCountyRequest updateCountyRequest){
        County countyToUpdate = countyRepository.findById(id).orElseThrow();

        countyToUpdate.setId(updateCountyRequest.getId());
        countyToUpdate.setName(updateCountyRequest.getName());

        countyRepository.save(countyToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        County countyToDelete = countyRepository.findById(id).orElseThrow();
        countyRepository.delete(countyToDelete);
    }
}
