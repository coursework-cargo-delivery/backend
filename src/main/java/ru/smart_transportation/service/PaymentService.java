package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.entity.Payment;
import ru.smart_transportation.repo.PaymentRepository;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void addReceipt(Order order) {
        final var payment = new Payment();
        payment.setOrder(order);
        payment.setStatus(Boolean.FALSE);
        payment.setCost(BigDecimal.valueOf(0)); //todo рассчитай стоимость перевозки

        paymentRepository.save(payment);
    }
}
