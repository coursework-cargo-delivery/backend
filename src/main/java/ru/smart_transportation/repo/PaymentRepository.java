package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart_transportation.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}