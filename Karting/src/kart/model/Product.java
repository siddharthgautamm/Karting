package kart.model;

import java.util.Date;

//product model class
public class Product {

	private long id;
	private String title;
	private float price;
	private int quantity;
	private Date mfd;
	private Date expiryDate;

	public Product(long id, String title, float price, int quantity, Date mfd, Date expiryDate) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
	}

	public Product(long id, String title, float price, int quantity) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getMfd() {
		return mfd;
	}

	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product Id=" + id + ", Title=" + title + ", Price=" + price + ", Quantity=" + quantity
				+ ", Date of Manufacture= " + mfd + ", ExpiryDate=" + expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mfd == null) ? 0 : mfd.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + quantity;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Product other = (Product) obj;

		if (id != other.id)
			return false;
		return true;
	}

}
