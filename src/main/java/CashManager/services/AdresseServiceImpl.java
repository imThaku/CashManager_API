package CashManager.services;

import CashManager.dao.AdresseRepository;
import CashManager.dao.ProductRepository;
import CashManager.dto.adresse.AdresseDto;
import CashManager.models.adresse.Adresse;
import CashManager.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServiceImpl implements AdresseService{

    @Autowired
    private AdresseRepository adresseRepository;

    public List<Adresse> getAllAdresse() {
        return adresseRepository.findAll();
    }

    public Adresse getAdresseById(Integer id) {
        return this.adresseRepository.findOne(id);
    }

    public Adresse addNewAdresse(Adresse adresse) {
        return this.adresseRepository.save(adresse);
    }

    public void deleteAdresse(Integer id){
        this.adresseRepository.delete(id);
    }
}
