package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.entity.Payment;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Transactional
    @Modifying
    @Query("update Payment p set p.status = ?1 where p.order = ?2")
    int updateStatusByOrder(Boolean status, Order order);

    @Query("select p from Payment p where p.order = ?1")
    Optional<Payment> findByOrder(Order order);
}