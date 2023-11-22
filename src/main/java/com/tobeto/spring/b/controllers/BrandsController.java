package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
        public Brand getById(@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }
    @PutMapping({"{id}"})
    public void update(@PathVariable int id, @RequestBody Brand brand) {
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        brandToUpdate.setId(brand.getId());
        brandToUpdate.setName(brand.getName());
        brandRepository.save(brandToUpdate);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       Brand brandToDelete = brandRepository.findById(id).orElseThrow();
       brandRepository.delete(brandToDelete);

        //brandRepository.deleteById(id);
    }



}
