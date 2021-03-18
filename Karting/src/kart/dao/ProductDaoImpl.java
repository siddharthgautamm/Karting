package kart.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kart.model.Product;
import kart.util.DateUtil;
import kart.util.InputUtil;

public class ProductDaoImpl implements IProductDao {

	private static Map<Long, Product> products;
	private static DateUtil date = new DateUtil();
	private static long origin = 1200L;

	static {

		products = new HashMap<Long, Product>();

	}

//	Product object is added to the hashmap
	@Override
	public boolean add(Product product) {

		int initialSize = products.size();

		products.put(origin++, product);

		if (products.size() > initialSize)
			return true;
		else
			return false;

	}

//	Product object with provided id is updated
	@Override
	public boolean update(int productId) {
		for (Map.Entry<Long, Product> entry : products.entrySet()) {
			Product obj = new Product();
			obj = entry.getValue();
			if (obj.getId() == productId) {
				Scanner scanner = InputUtil.getScanner();
				System.out.println(
						"Enter Product id, name, price, qty, Manufacturing Date (dd-MM-yyyy), Expiry Date (dd-MM-yyyy): ");
				int id = scanner.nextInt();
				String name = scanner.next();
				int price = scanner.nextInt();
				int quantity = scanner.nextInt();
				String date1 = scanner.next();
				String date2 = scanner.next();

				Date mfd = date.getDate(date1);
				Date expiry = date.getDate(date2);
				Product prod = new Product(id, name, price, quantity, mfd, expiry);
				products.replace(entry.getKey(), prod);

				products.replace(entry.getKey(), prod);
				return true;
			}
		}

		return false;
	}

//	Delete the product with given product id
	@Override
	public boolean delete(int productId) {
		for (Map.Entry<Long, Product> entry : products.entrySet()) {
			Product obj = new Product();
			obj = entry.getValue();
			if (obj.getId() == productId) {
				products.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}

//	returns the product with given product id
	@Override
	public Product getProduct(int productId) {
		for (Map.Entry<Long, Product> entry : products.entrySet()) {
			Product obj = new Product();
			obj = entry.getValue();
			if (obj.getId() == productId) {
				return obj;
			}
		}
		return new Product();
	}

//	returns all the products in the cart
	@Override
	public List<Product> getAllProduct() {
		ArrayList<Product> list = new ArrayList<Product>();
		Collection<Product> productlist = products.values();
		for (Product p : productlist) {
			list.add(p);

		}
		return list;
	}
	
//	@Override
//	public boolean validateId(long id)
//	{
//		String identity=String.valueOf(id);
//		if(identity.co
//		for(int i=0;i<identity.length();i++)
//		{
//			if(identity.charAt(i))
//		}
//		return true;
//	}

}
