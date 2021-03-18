package kart.controller;

import java.util.Date;
import java.util.Scanner;

import kart.dao.CustomerDaoImpl;
import kart.model.Customer;
import kart.model.Product;
import kart.service.AdminOperationsProductImpl;
import kart.service.IAdminOperationsProduct;
import kart.util.DateUtil;
import kart.util.InputUtil;

//main method
public class MainController {
	private static IAdminOperationsProduct productService = new AdminOperationsProductImpl();
	private static CustomerDaoImpl customer = new CustomerDaoImpl();
	private static DateUtil date = new DateUtil();

	public static void main(String[] args) {

		putSomeValues();
		runApplication();

	}

	// put some dummy data
	private static void putSomeValues() {

		Date date1 = date.getDate("01-01-2020");
		Date date2 = date.getDate("01-12-2021");
		Date date3 = date.getDate("20-12-2020");
		Date date4 = date.getDate("01-01-2021");
		Date date5 = date.getDate("01-12-2019");
		Date date6 = date.getDate("01-12-2021");
		Date date7 = date.getDate("01-01-2021");
		Date date8 = date.getDate("01-11-2021");
		Product product1 = new Product(1001, "Toffee", 1, 1000, date1, date2);
		productService.add(product1);
		Product product2 = new Product(2002, "Juice", 50, 50, date3, date4);
		productService.add(product2);
		Product product3 = new Product(3003, "DishWash", 20, 200, date5, date6);
		productService.add(product3);
		Product product4 = new Product(4004, "Bulb", 45, 250, date7, date8);
		productService.add(product4);

		Customer c1 = new Customer(1001, "Siddharth", "siddharth@gmail.com", 9090909090L,
				"kalkaji");
		Customer c2 = new Customer(2002, "Sunny", "sunny@gmail.com", 7049323462L, "CR Park");
		customer.register(c2);
		customer.register(c1);

	}

//main menu 
	private static void runApplication() {

		Scanner scanner = InputUtil.getScanner();
		CustomerController customerController = new CustomerController();
		AdminController adminController = new AdminController();
		while (true) {
			System.out.println("Welcome to FKart");
			System.out.println("1.Customer \n2.Admin \n3.Exit");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				customerController.operations();
				break;

			case 2:
				adminController.operations();
				break;

			case 3:
				System.out.println("Exiting!!");
				System.exit(0);

			}
		}
	}
}
