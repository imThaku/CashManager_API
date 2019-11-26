package CashManager.services;

import CashManager.dao.AdresseRepository;
import CashManager.dao.OrderRepository;
import CashManager.dao.PayementRepository;
import CashManager.dto.adresse.AdresseDto;
import CashManager.models.order.Order;
import CashManager.models.payement.Payement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PayementRepository paymentRepository;

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

    public Order editOrder(Order order) {
        return this.orderRepository.save(order);
    }

    /**
     * Set the payment in the order and update it
     * @param order Order to update
     * @param payment Order payment
     */
    public void setPayment(Order order, Payement payment) {
        order.setPayementDate(new Date());
        order.setPayement(payment);
        paymentRepository.save(payment);
        editOrder(order);
    }
}
