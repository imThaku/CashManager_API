package CashManager.services;

import CashManager.models.product.Product;
import CashManager.models.user.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Integer id);

    public Customer addNewCustomer(Customer customer);

    public Customer editCustomer(Customer customer);
}
