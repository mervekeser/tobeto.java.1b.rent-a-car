package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public void add(AddBrandRequest addBrandRequest) {
        // Aynı isimde iki brand olamaz

        if(brandRepository.existsByName(addBrandRequest.getName().trim()))
        {
            throw new RuntimeException("Aynı isimle iki marka eklenemez.");
        }

        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);

    }

    @Override
    public GetBrandResponse getById(int id) {

            Brand brand = brandRepository.findById(id).orElseThrow();

            GetBrandResponse getBrandResponse = new GetBrandResponse();
            getBrandResponse.setName(brand.getName());

            return getBrandResponse;
        }

    @Override
    public List<GetBrandListResponse> getByName(String name, int id) {
        List<Brand> brandList = brandRepository.findByNameLikeOrIdEquals("%"+name+"%", id);
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();
        for(Brand brand : brandList){
            getBrandListResponses.add(new GetBrandListResponse(brand.getName()));
        }
        return getBrandListResponses;
    }
    @Override
    public List<GetBrandListResponse> search(String name){
        List<Brand> brands = brandRepository.search2(name);

        // MAP
        // Lambda Expression & Stream API

        return brandRepository.search3(name);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, int id) {
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        brandToUpdate.setId(updateBrandRequest.getId());
        brandToUpdate.setName(updateBrandRequest.getName());

        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(int id){
        brandRepository.deleteById(id);
    }

}

