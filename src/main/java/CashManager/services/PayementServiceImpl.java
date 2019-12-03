package CashManager.services;

import CashManager.dao.OrderStatusRepository;
import CashManager.dao.PayementRepository;
import CashManager.models.order.OrderStatus;
import CashManager.models.payement.Payement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementServiceImpl implements PayementService {

    @Autowired
    private PayementRepository payementRepository;

    public Payement getPayementById(Integer id) {
        return this.payementRepository.findOne(id);
    }

    public Payement addNewPayement(Payement payement) {
        return this.payementRepository.save(payement);
    }

}
