package CashManager.services;

import CashManager.dao.PayementInfoRepository;
import CashManager.dao.PayementRepository;
import CashManager.models.payement.Payement;
import CashManager.models.payement.PayementInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementInfoServiceImpl implements PayementInfoService {

    @Autowired
    private PayementInfoRepository payementInfoRepository;

    public PayementInfo getPayementInfoById(Integer id) {
        return this.payementInfoRepository.findOne(id);
    }

}
