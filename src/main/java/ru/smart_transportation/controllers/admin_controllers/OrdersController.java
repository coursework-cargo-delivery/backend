package ru.smart_transportation.controllers.admin_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smart_transportation.dto.response.OrdersResponse;
import ru.smart_transportation.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("admin")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    ResponseEntity<OrdersResponse> getAllOrders(){
        final var response = orderService.getAllOrders();

        return ResponseEntity.ok(response);
    }
}
