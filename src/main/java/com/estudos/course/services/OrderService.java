package com.estudos.course.services;

import com.estudos.course.models.Order;
import com.estudos.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not foung"));
    }
}
