package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import com.tobeto.spring.b.services.abstracts.OrderService;
import com.tobeto.spring.b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        this.orderService.add(addOrderRequest);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest){
        this.orderService.update(updateOrderRequest, id);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        this.orderService.deleteById(id);
    }

    @GetMapping
    public List<GetOrderListResponse> getAll(){
        return this.orderService.getAll();
    }

    @GetMapping({"id"})
    public GetOrderResponse getById(@PathVariable int id){
        return this.orderService.getById(id);
    }

    @GetMapping({"start, end"})
    public List<GetOrderListResponse> getByStartRentAndEndRent(LocalDate start, LocalDate end){
        return this.orderService.getByStartRentAndEndRent(start, end);
    }

}
