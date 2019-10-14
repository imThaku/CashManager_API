package CashManager.services;

import CashManager.dao.OrderRepository;
import CashManager.dao.OrderStatusRepository;
import CashManager.models.order.Order;
import CashManager.models.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public OrderStatus getOrderStatusById(Integer id) {
        return this.orderStatusRepository.findOne(id);
    }

}
