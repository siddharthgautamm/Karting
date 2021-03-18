package kart.service;

import java.util.Date;
import java.util.List;
import kart.dao.CartDaoImpl;
import kart.dao.CustomerDaoImpl;
import kart.dao.ProductDaoImpl;
import kart.model.Customer;
import kart.model.Product;

public class CustomerOperationsImpl implements ICustomerOperations {

	CustomerDaoImpl customerDao = new CustomerDaoImpl();
	CartDaoImpl cartDao = new CartDaoImpl();
	ProductDaoImpl productDao = new ProductDaoImpl();

//	adds customer to the customer hashmap
	@Override
	public boolean register(Customer customer) {

		return customerDao.register(customer);
	}

//adds product to the cart with same customerId, calls add from cartDaoImpl
	@Override
	public boolean add(int productId, int customerId) {

		Product prod = productDao.getProduct(productId);
		return cartDao.add(prod, customerId);
	}

//returns list of products that are added in the given cart
	@Override
	public List<Product> viewCart(int cartId) {

		return cartDao.viewCart(cartId);
	}

//returns list of products that are not expired yet
	@Override
	public List<Product> view() {
		List<Product> nonExpiredProducts;

		nonExpiredProducts = (productDao.getAllProduct());

		Product p = new Product();
		Date date = new Date();
		for (int i = 0; i < nonExpiredProducts.size(); i++) {
			p = nonExpiredProducts.get(i);
			if (date.before(p.getExpiryDate())) {
				nonExpiredProducts.remove(i);
			}
		}

		return nonExpiredProducts;

	}

}
