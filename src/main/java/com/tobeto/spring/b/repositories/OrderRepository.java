package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.order.GetOrderListResponse(o.date, o.startRent, " +
            "o.endRent, o.totalPrice, o.paymentType) FROM Order o WHERE o.startRent = :start AND o.endRent = :end")
    List<GetOrderListResponse> findByStartRentAndEndRent(LocalDate start, LocalDate end);
}
