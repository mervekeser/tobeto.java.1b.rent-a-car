package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.County;
import com.tobeto.spring.b.repositories.CountyRepository;
import com.tobeto.spring.b.services.abstracts.CountyService;
import com.tobeto.spring.b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyListReponse;
import com.tobeto.spring.b.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CountyManager implements CountyService {
    private final CountyRepository countyRepository;

    @Override
    public List<GetCountyListReponse> getAll() {

            List<County> countyList = countyRepository.findAll();
            List<GetCountyListReponse> countyListReponses = new ArrayList<GetCountyListReponse>();
            for (County county : countyList){
                GetCountyListReponse countyListReponse = new GetCountyListReponse();
                countyListReponse.setName(county.getName());

                countyListReponses.add(countyListReponse);
            }
            return countyListReponses;
    }

    @Override
    public GetCountyResponse getById(int id) {
        County county = countyRepository.findById(id).orElseThrow();

        GetCountyResponse getCountyResponse = new GetCountyResponse();
        getCountyResponse.setName(county.getName());

        return getCountyResponse;
    }

    @Override
    public void add(AddCountyRequest addCountyRequest) {
        County county = new County();

        county.setName(addCountyRequest.getName());

        countyRepository.save(county);
    }

    @Override
    public void update(UpdateCountyRequest updateCountyRequest, int id) {
        County countyToUpdate = countyRepository.findById(id).orElseThrow();

        countyToUpdate.setId(updateCountyRequest.getId());
        countyToUpdate.setName(updateCountyRequest.getName());

        countyRepository.save(countyToUpdate);
    }

    @Override
    public void delete(int id) {

        countyRepository.deleteById(id);
    }
}
