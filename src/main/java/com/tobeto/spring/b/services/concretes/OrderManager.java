package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import com.tobeto.spring.b.services.abstracts.OrderService;
import com.tobeto.spring.b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void add(AddOrderRequest addOrderRequest) {
        Order order = new Order();

        order.setDate(addOrderRequest.getDate());
        order.setStartRent(addOrderRequest.getStartRent());
        order.setEndRent(addOrderRequest.getEndRent());
        order.setPaymentType(addOrderRequest.getPaymentType());
        order.setTotalPrice(addOrderRequest.getTotalPrice());

        orderRepository.save(order);
    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest, int id) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow();

        orderToUpdate.setId(updateOrderRequest.getId());
        orderToUpdate.setDate(updateOrderRequest.getDate());
        orderToUpdate.setStartRent(updateOrderRequest.getStartRent());
        orderToUpdate.setEndRent(updateOrderRequest.getEndRent());
        orderToUpdate.setTotalPrice(updateOrderRequest.getTotalPrice());
        orderToUpdate.setPaymentType(updateOrderRequest.getPaymentType());

        orderRepository.save(orderToUpdate);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<GetOrderListResponse> getAll() {
        List<Order> orderList = orderRepository.findAll();
        List<GetOrderListResponse> getOrderListResponses = new ArrayList<>();
        for(Order order : orderList){
            GetOrderListResponse getOrderResponse = new GetOrderListResponse();
            getOrderResponse.setDate(order.getDate());
            getOrderResponse.setStartRent(order.getStartRent());
            getOrderResponse.setEndRent(order.getEndRent());
            getOrderResponse.setPaymentType(order.getPaymentType());
            getOrderResponse.setTotalPrice(order.getTotalPrice());

            getOrderListResponses.add(getOrderResponse);
        }

        return getOrderListResponses;
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        getOrderResponse.setDate(order.getDate());

        return getOrderResponse;

    }

    @Override
    public List<GetOrderListResponse> getByStartRentAndEndRent(LocalDate start, LocalDate end) {
        return orderRepository.findByStartRentAndEndRent(start, end);
    }

}
