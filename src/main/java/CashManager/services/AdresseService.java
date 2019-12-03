package CashManager.services;

import CashManager.dto.adresse.AdresseDto;
import CashManager.models.adresse.Adresse;
import CashManager.models.product.Product;

import java.util.List;

public interface AdresseService {

    public List<Adresse> getAllAdresse();

    public Adresse getAdresseById(Integer id);

    public Adresse addNewAdresse(Adresse adresseDto);

    public void deleteAdresse(Integer id);
}
