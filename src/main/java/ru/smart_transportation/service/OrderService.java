package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.dto.request.NewOrder;
import ru.smart_transportation.dto.response.CargoTypesResponse;
import ru.smart_transportation.dto.response.OrderResponse;
import ru.smart_transportation.dto.response.OrdersResponse;
import ru.smart_transportation.entity.CargoType;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.etc.DatabaseOrderStatus;
import ru.smart_transportation.repo.*;

import java.sql.Date;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AppUserService userService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    CargoTypeRepository cargoTypeRepository;

    @Autowired
    PaymentService paymentService;

    public OrderResponse createOrder(NewOrder request) {
        final var order = new Order();
        final var user = userService.getCurrentUser().orElseThrow();
        final var client = clientRepository.findClientByAppUser(user);
        final var station1 = stationRepository.findById(request.getStation1()).orElseThrow();
        final var station2 = stationRepository.findById(request.getStation2()).orElseThrow();

        order.setClient(client);
        order.setStation1(station1);
        order.setStation2(station2);
        order.setCreationDate(new Date(System.currentTimeMillis()));
        order.setStatus(orderStatusRepository
                .findById(DatabaseOrderStatus.PENDING.getId()).orElseThrow());
        order.setCargoType(cargoTypeRepository
                .findById(request.getCargoType()).orElseThrow());
        order.setWeight(request.getWeight());
        order.setComment(request.getComment());

        final var savedOrder = orderRepository.save(order);

        return convertOrderToOrderResponse(savedOrder);
    }


    public OrdersResponse getOwnOrders() {
        final var user = userService.getCurrentUser().orElseThrow();
        final var client = clientRepository.findClientByAppUser(user);
        final var orders = orderRepository.findAllByClient(client);
        
        return new OrdersResponse(
                orders.stream()
                        .map(this::convertOrderToOrderResponse)
                        .sorted((a, b) -> b.getId() - a.getId())
                        .collect(Collectors.toList())
        );
    }

    public OrdersResponse getAllOrders() {
        final var orders = orderRepository.findAll();

        return new OrdersResponse(
                orders.stream()
                        .map(this::convertOrderToOrderResponse)
                        .collect(Collectors.toList())
        );
    }
    
    private OrderResponse convertOrderToOrderResponse(Order order){
        final var response = new OrderResponse();
        response.setId(order.getId());
        response.setStation1(order.getStation1().getId());
        response.setStation2(order.getStation2().getId());
        response.setCreationDate(order.getCreationDate());
        response.setStatus(order.getStatus().getName());
        response.setCargoType(order.getCargoType().getName());
        response.setWeight(order.getWeight());
        response.setComment(order.getComment());

        return response;
    }

    public OrderResponse changeOrderStatus(Integer orderId, Integer newStatusIs) {
        final var newStatus = orderStatusRepository.findById(newStatusIs).orElseThrow();
        orderRepository.updateStatusById(newStatus, orderId);
        final var order = orderRepository.findById(orderId).orElseThrow();
        paymentService.addReceipt(order);

        return convertOrderToOrderResponse(order);
    }

    public CargoTypesResponse getCargoTypes(){
        return new CargoTypesResponse(
                cargoTypeRepository
                        .findAll()
                        .stream()
                        .map(CargoType::getName)
                        .collect(Collectors.toList())
        );
    }
}
