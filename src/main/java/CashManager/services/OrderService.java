package CashManager.services;

import CashManager.models.order.Order;
import CashManager.models.payement.Payement;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrder();

    public Order getOrderById(Integer id);

    public Order addNewOrder(Order order);

    public void deleteOrder(Integer id);

    public Order editOrder(Order order);

    public void setPayment(Order order, Payement payment);
}
