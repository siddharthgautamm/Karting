package kart.model;

import java.util.HashMap;
import java.util.List;

//cart model class
public class Cart {

	private long id;
	HashMap<Customer, List<Product>> cart = new HashMap<Customer, List<Product>>();

	public Cart(long id, HashMap<Customer, List<Product>> cart) {
		this.id = id;
		this.cart = cart;
	}

	public Cart() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public HashMap<Customer, List<Product>> getCart() {
		return cart;
	}

	public void setCart(HashMap<Customer, List<Product>> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cart=" + cart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
