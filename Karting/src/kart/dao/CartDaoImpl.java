package kart.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kart.model.Product;

// cart class 
public class CartDaoImpl implements ICartDao {
	static HashMap<Integer, ArrayList<Product>> cart;
	static {
		cart = new HashMap<Integer, ArrayList<Product>>();
	}

//Add product into the cart, Product is added into the cart with customer id.
//If cart not available, a cart with customer id is added
	@Override
	public boolean add(Product prod, int customerId) {
		ArrayList<Product> arr1 = new ArrayList<Product>();
		ArrayList<Product> arr2 = new ArrayList<Product>();
		if (cart.containsKey((Object) customerId)) {
			arr2=cart.get((Object) customerId);
			for(int i=0;i<arr2.size();i++)
			{
				if(arr2.contains(prod))
				{
					int quantity=arr2.get(i).getQuantity();
					arr2.get(i).setQuantity(quantity+1);
				}
			}
			cart.put(customerId, arr2);
			return true;
		} else {
			Product product=new Product();
			product=prod;
			product.setQuantity(1);
			arr1.add(product);
			
			cart.put(customerId, arr1);
			return true;
		}

	}
	
//Cart with the given User id is returned
	@Override
	public List<Product> viewCart(int id) {

		for (Map.Entry<Integer, ArrayList<Product>> entry : cart.entrySet()) {
			if (cart.containsKey(id)) {
				return (entry.getValue());
			}

		}
		return new ArrayList<Product>();

	}
}
