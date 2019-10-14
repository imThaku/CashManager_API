package CashManager.dao;

import CashManager.models.order.Order;
import CashManager.models.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {

    List<Order>findByStatus(String status);
}
