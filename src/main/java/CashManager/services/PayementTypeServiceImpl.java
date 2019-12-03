package CashManager.services;

import CashManager.dao.PayementRepository;
import CashManager.dao.PayementTypeRepository;
import CashManager.models.payement.Payement;
import CashManager.models.payement.PayementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementTypeServiceImpl implements PayementTypeService {

    @Autowired
    private PayementTypeRepository payementTypeRepository;

    public PayementType getPayementTypeById(Integer id) {
        return this.payementTypeRepository.findOne(id);
    }

}
