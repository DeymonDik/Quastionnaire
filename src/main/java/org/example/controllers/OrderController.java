package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.entities.AnswerEntity;
import org.example.services.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController("order")
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("list")
    public List<AnswerEntity> getOrders() {
        return orderService.getOrders();
    }
}
