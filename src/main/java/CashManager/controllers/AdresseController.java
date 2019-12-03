package CashManager.controllers;

import CashManager.dto.adresse.AdresseDto;
import CashManager.dto.adresse.AdresseTypeDto;
import CashManager.models.adresse.Adresse;
import CashManager.models.adresse.AdresseType;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import CashManager.services.AdresseService;
import CashManager.services.CustomerService;
import CashManager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/adresse")
    public List<Adresse> index() {
        return this.adresseService.getAllAdresse();
    }

    @GetMapping("/adresse/{id}")
    public Adresse show(@PathVariable String id) {
        int adresseId = Integer.parseInt(id);
        return this.adresseService.getAdresseById(adresseId);
    }

    @PostMapping("/adresse")
    public Adresse create(@RequestBody Map<String, String> body) {
        String city = body.get("city");
        Integer cityCode = Integer.parseInt(body.get("cityCode"));
        String adresseType = body.get("adresseType");
        String libelle = body.get("libelle");
        String libelleComp = body.get("libelleComp");

        return this.adresseService.addNewAdresse(Adresse.builder().city(city)
                .cityCode(cityCode)
                .libelle(libelle)
                .libelleComp(libelleComp)
                .adresseType(AdresseType.builder().type(adresseType).build()).build());
    }

    @PostMapping("/adresse/{id}")
    public Adresse createUserAdresse(@RequestBody Map<String, String> body,@PathVariable String id) {
        Adresse adresse = new Adresse();
        String city = body.get("city");
        Integer cityCode = Integer.parseInt(body.get("cityCode"));
        String libelle = body.get("libelle");
        String libelleComp = body.get("libelleComp");
        adresse = Adresse.builder().city(city)
                .cityCode(cityCode)
                .libelle(libelle)
                .libelleComp(libelleComp)
                .build();
        this.adresseService.addNewAdresse(adresse);
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        customer.setAdresse(adresse);
        this.customerService.editCustomer(customer);
        return adresse;
    }

    @DeleteMapping("/adresse/{id}")
    public void deleteAdresse(@PathVariable String id){
        int adresseId = Integer.parseInt(id);
        this.adresseService.deleteAdresse(adresseId);
    }
}
