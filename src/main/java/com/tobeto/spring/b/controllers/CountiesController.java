package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.CountyService;
import com.tobeto.spring.b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyListReponse;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyResponse;
import com.tobeto.spring.b.entities.County;
import com.tobeto.spring.b.repositories.CountyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/counties")
@AllArgsConstructor
public class CountiesController {
    private final CountyService countyService;

    @PostMapping
    public void add(@RequestBody AddCountyRequest addCountyRequest){
        this.countyService.add(addCountyRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateCountyRequest updateCountyRequest){
        this.countyService.update(updateCountyRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.countyService.delete(id);
    }

    @GetMapping
    public List<GetCountyListReponse> getAll(){
        return this.countyService.getAll();
    }

    @GetMapping({"id"})
    public GetCountyResponse getById(@PathVariable int id){
        return this.countyService.getById(id);
    }


}
