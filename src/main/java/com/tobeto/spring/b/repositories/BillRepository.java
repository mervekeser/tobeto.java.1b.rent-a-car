package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Bill;
import com.tobeto.spring.b.services.dtos.responses.bill.GetBillListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.bill.GetBillListResponse(b.date, b.timeRent, b.price) FROM Bill b" +
            " WHERE b.price = :price")
    List<GetBillListResponse> findByPriceLessThanEqual(double price);
}
