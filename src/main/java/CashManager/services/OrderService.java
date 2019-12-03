package CashManager.services;

import CashManager.dto.adresse.AdresseDto;
import CashManager.models.order.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrder();

    public Order getOrderById(Integer id);

    public Order addNewOrder(Order order);

    public void deleteOrder(Integer id);
}
