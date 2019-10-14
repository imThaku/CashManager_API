package CashManager.services;

import CashManager.models.order.Order;
import CashManager.models.order.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    public OrderStatus getOrderStatusById(Integer id);

}
