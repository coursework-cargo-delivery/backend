package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.entity.Payment;
import ru.smart_transportation.entity.Station;
import ru.smart_transportation.repo.PaymentRepository;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired MapService mapService;

    public void addReceipt(Order order) {
        final float price = this.countPrice(order);
        final var payment = new Payment();

        payment.setOrder(order);
        payment.setStatus(Boolean.FALSE);
        payment.setCost(BigDecimal.valueOf(price)); //todo рассчитай стоимость перевозки

        paymentRepository.save(payment);
    }

    public float countPrice(Order order){
        return order.getWeight() * 10;
    }

    public void pay(Order order){
        paymentRepository.updateStatusByOrder(Boolean.TRUE, order);
    }
}
