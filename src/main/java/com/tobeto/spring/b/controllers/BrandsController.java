package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<GetBrandListResponse>();
        for(Brand brand : brandList){
            GetBrandListResponse brandListResponse = new GetBrandListResponse();
            brandListResponse.setName(brand.getName());

            brandListResponses.add(brandListResponse);
        }
        return brandListResponses;
    }

    @GetMapping("{id}")
        public GetBrandResponse getById(@PathVariable int id) {

        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);
    }

    @PutMapping({"{id}"})
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();

        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       Brand brandToDelete = brandRepository.findById(id).orElseThrow();
       brandRepository.delete(brandToDelete);

        //brandRepository.deleteById(id);
    }

}
