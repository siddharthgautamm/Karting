package kart.service;

import java.util.List;

import kart.model.Customer;
import kart.model.Product;

public interface ICustomerOperations {

	boolean register(Customer customer);

	List<Product> view();

	boolean add(int productId, int customerId);

	List<Product> viewCart(int cartId);

}
