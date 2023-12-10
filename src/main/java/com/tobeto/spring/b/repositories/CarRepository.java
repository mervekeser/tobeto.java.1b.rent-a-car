package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
        @Query("Select new com.tobeto.spring.b.services.dtos.responses.car" +
        ".GetCarListResponse(c.id, c.modelYear, new com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse(b.name))" +
        "from Car c INNER JOIN c.brand b")
        List<GetCarListResponse> getAll();

        @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse(c.modelYear, c.modelName," +
                " c.color, c.price) FROM Car c WHERE c.modelName = :modelName")
        List<GetCarListResponse> findByModelName(String modelName);

        /*List<Car> getAllByModelNameOrBrandId(String model_name, int brand_id);

        List<Car> getBrandId (List<Integer> brands);

        List<Car> getByModelNameContains(String model_name);

        List<Car> getByModelNameStartsWith(String model_name);*/

        //jpql
        /*@Query("From Car where modelName=:modelName and brandId=:brandId")
        List<Car> getByNameAndBrand(String name, int brand_id);*/


}
