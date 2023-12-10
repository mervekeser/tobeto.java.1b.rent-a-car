package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest){
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

    @GetMapping()
    public List<GetBrandListResponse> getByName(@RequestParam String name, @RequestParam int id){
        return this.brandService.getByName(name, id);
    }
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @GetMapping("search")
    public List<GetBrandListResponse> search(@RequestParam String name){
        return this.brandService.search(name);
    }



}
