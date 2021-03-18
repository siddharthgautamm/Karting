package kart.dao;

import java.util.List;

import kart.model.Product;

public interface IProductDao {

	public boolean add(Product product);

	public boolean update(int productId);

	public boolean delete(int productId);

	public Product getProduct(int productId);

	public List<Product> getAllProduct();

//	boolean validateId(long id);
}
