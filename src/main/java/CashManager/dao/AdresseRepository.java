package CashManager.dao;

import CashManager.dto.adresse.AdresseDto;
import CashManager.models.adresse.Adresse;
import CashManager.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {

    List<Adresse>findByLibelle(String libelle);
}
