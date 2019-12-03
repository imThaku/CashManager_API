package CashManager.services;

import CashManager.models.payement.Payement;

public interface PayementService {

    public Payement getPayementById(Integer id);

    public Payement addNewPayement(Payement payement);

}
