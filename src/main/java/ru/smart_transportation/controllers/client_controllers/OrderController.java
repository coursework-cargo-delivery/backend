package ru.smart_transportation.controllers.client_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smart_transportation.dto.request.NewOrder;
import ru.smart_transportation.dto.response.CargoTypesResponse;
import ru.smart_transportation.dto.response.OrderResponse;
import ru.smart_transportation.dto.response.OrdersResponse;
import ru.smart_transportation.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    ResponseEntity<OrdersResponse> getOwnOrders(){
        OrdersResponse response = orderService.getOwnOrders();
        return ResponseEntity.ok(response);
    }

    @PostMapping("orders/add")
    ResponseEntity<OrderResponse> addOrder(@RequestBody NewOrder newOrder){
        OrderResponse response = orderService.createOrder(newOrder);
        return ResponseEntity.ok(response);
    }

    @GetMapping("cargo/types")
    ResponseEntity<CargoTypesResponse> getCargoTypes(){
        CargoTypesResponse response = orderService.getCargoTypes();
        return ResponseEntity.ok(response);
    }
}
