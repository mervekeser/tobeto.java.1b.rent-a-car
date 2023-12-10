package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderResponse;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    void add(AddOrderRequest addOrderRequest);
    void update(UpdateOrderRequest updateOrderRequest, int id);
    void deleteById(int id);
    List<GetOrderListResponse> getAll();
    GetOrderResponse getById(int id);
    List<GetOrderListResponse> getByStartRentAndEndRent(LocalDate start, LocalDate end);
}
