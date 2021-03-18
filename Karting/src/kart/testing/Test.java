package kart.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kart.dao.ProductDaoImpl;
import kart.model.Product;
import kart.service.CustomerOperationsImpl;

class Testing {

	private CustomerOperationsImpl obj;
	private List<Product> list;
	private Product e = new Product();
	private ProductDaoImpl prod;

	@BeforeEach
	void setUp() throws Exception {
		obj = new CustomerOperationsImpl();
		list = new ArrayList<Product>();
		e = new Product();
		prod=new ProductDaoImpl();

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;

	}

	@Test
	void addTest() {
		assertEquals(obj.add(1001, 1001), true);
	}

	@Test
	void viewCartTest() {
		e.setId(0);
		list.add(e);
		assertEquals(obj.viewCart(1001), list);
		assertNotEquals(obj.viewCart(2002), list);

	}

	@Test
	void viewTest() {

		assertEquals(obj.view(), list);

		String s = "22-02-2021";
		Date date1;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(s);
			e.setExpiryDate(date1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		list.add(e);
		System.out.println(obj.view()+"\n"+ list);

		assertNotEquals(obj.view(), list);

	}

	@Test
	void viewTest1() {
		String s = "22-02-2022";
		try {
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(s);
			e.setId(1001);
			e.setExpiryDate(date1);
			prod.add(e);			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		list.add(e);
		List<Product> l1=new ArrayList<Product>();
		l1=obj.view();
		System.out.println(l1 + "\n" + list);
		
		assertNotEquals(obj.view(), list);

	}

}
