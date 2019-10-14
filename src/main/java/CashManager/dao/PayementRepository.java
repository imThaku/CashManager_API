package CashManager.dao;

import CashManager.models.order.Order;
import CashManager.models.order.OrderStatus;
import CashManager.models.payement.Payement;
import CashManager.models.payement.PayementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayementRepository extends JpaRepository<Payement,Integer> {

    List<Order>findByPayementType(PayementType payementType);
}
