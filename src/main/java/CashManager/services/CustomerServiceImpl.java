package CashManager.services;

import CashManager.dao.CustomerRepository;
import CashManager.dao.ProductRepository;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return this.customerRepository.findOne(id);
    }

    public Customer addNewCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }


    public Customer editCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
