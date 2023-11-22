package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping({"id"})
    public Order getById(@PathVariable int id){
        return orderRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Order order){
        orderRepository.save(order);
    }

    @PutMapping({"id"})
    public void update(@PathVariable int id, @RequestBody Order order){
        Order orderToUpdate = orderRepository.findById(id).orElseThrow();
        orderToUpdate.setId(order.getId());
        orderToUpdate.setDate(order.getDate());
        orderToUpdate.setStartRent(order.getStartRent());
        orderToUpdate.setEndRent(order.getEndRent());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        orderToUpdate.setPaymentType(order.getPaymentType());
        orderRepository.save(orderToUpdate);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable int id){
        Order orderToDelete = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(orderToDelete);
    }
}
