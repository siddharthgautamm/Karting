package kart.dao;

import java.util.HashMap;

import kart.model.Customer;

public class CustomerDaoImpl implements ICustomerDao {
	ICartDao cartDaoImpl = new CartDaoImpl();
	private static HashMap<Integer, Customer> customerCart;
	private static int cartAddress = 1;

	static {
		customerCart = new HashMap<Integer, Customer>();
	}

//	customer object is added to the hashmap
	@Override
	public boolean register(Customer customer) {

		int initialSize = customerCart.size();

		customerCart.put(cartAddress++, customer);

		if (customerCart.size() > initialSize)
			return true;
		else
			return false;
	}
	
//	all the customer objects are returned
	public Object[] showCustomer(){
		Object[] values=customerCart.values().toArray();
		return values;
	}

}
