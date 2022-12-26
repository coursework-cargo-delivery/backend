package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smart_transportation.entity.Client;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.entity.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Transactional
    @Modifying
    @Query("update Order o set o.status = ?1 where o.id = ?2")
    int updateStatusById(OrderStatus status, Integer id);

    @Query("select o from Order o where o.client = ?1")
    List<Order> findAllByClient(Client client);
}