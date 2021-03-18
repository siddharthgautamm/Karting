package kart.service;

import java.util.List;

import kart.model.*;

public interface IAdminOperationsProduct {

	boolean add(Product product);

	boolean update(int productId);

	boolean delete(int productId);

	Product getProduct(int productId);

	List<Product> getAllProduct();

	boolean validate(String name, String pass);
}
