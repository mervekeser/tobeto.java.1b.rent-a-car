package com.tobeto.spring.b.repositories;


import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// DATA JPA
// Generic
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findByNameLikeOrIdEquals(String name, int id);

    @Query("SELECT b FROM Brand b Where b.name LIKE %:name%")
    List<Brand> findByName(String name);

    boolean existsByName(String name);

    @Query(value = "Select * from brands Where name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);

    // b => Brand
    // expected => GetBrandListResponse
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse(b.name) " +
            "FROM Brand b Where b.name LIKE %:name%")
    List<GetBrandListResponse> search3(String name);

}
