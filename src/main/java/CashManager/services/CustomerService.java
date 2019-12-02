package CashManager.services;

import CashManager.models.product.Product;
import CashManager.models.user.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    Customer addNewCustomer(Customer customer);

    Customer editCustomer(Customer customer);

    void clearCart(Customer customer);
}
