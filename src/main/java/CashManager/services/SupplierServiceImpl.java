package CashManager.services;

import CashManager.dao.PayementRepository;
import CashManager.dao.SupplierRepository;
import CashManager.models.payement.Payement;
import CashManager.models.user.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier getSupplierById(Integer id) {
        return this.supplierRepository.findOne(id);
    }

}
