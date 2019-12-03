package CashManager.dao;

import CashManager.dto.adresse.AdresseDto;
import CashManager.models.order.Order;
import CashManager.models.user.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order>findBySupplier(Supplier supplier);
}
