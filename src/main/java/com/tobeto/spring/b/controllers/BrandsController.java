package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        return this.brandService.getAll();
    }
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @PostMapping
     public void add(@RequestBody AddBrandRequest addBrandRequest){
        this.brandService.add(addBrandRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
