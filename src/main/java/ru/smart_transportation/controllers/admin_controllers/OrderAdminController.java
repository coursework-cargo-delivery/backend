package ru.smart_transportation.controllers.admin_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smart_transportation.dto.admin.request.OrderStatusRequest;
import ru.smart_transportation.dto.response.OrderResponse;
import ru.smart_transportation.dto.response.OrdersResponse;
import ru.smart_transportation.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("admin")
public class OrderAdminController {

    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    ResponseEntity<OrdersResponse> getAllOrders(){
        final var response = orderService.getAllOrders();

        return ResponseEntity.ok(response);
    }

    @PostMapping("order/status/change")
    ResponseEntity<OrderResponse> changeOrderStatus(@RequestBody OrderStatusRequest request){
        final var response = orderService
                .changeOrderStatus(request.getOrderId(), request.getNewStatusId());

        return ResponseEntity.ok(response);
    }
}
