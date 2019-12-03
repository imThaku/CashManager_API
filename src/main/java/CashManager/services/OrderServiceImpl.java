package CashManager.services;

import CashManager.dao.AdresseRepository;
import CashManager.dao.OrderRepository;
import CashManager.dto.adresse.AdresseDto;
import CashManager.models.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return this.orderRepository.findOne(id);
    }

    public Order addNewOrder(Order order) {
        System.out.println(order.toString());
        return this.orderRepository.save(order);
    }

    public void deleteOrder(Integer id){
        this.orderRepository.delete(id);
    }
}
