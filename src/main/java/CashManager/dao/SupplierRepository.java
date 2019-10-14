package CashManager.dao;

import CashManager.models.order.Order;
import CashManager.models.payement.Payement;
import CashManager.models.user.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    List<Order>findByUsername(String username);
}
