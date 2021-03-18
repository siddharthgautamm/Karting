package kart.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kart.dao.CustomerDaoImpl;
import kart.model.Product;
import kart.service.IAdminOperationsProduct;
import kart.service.AdminOperationsProductImpl;
import kart.util.DateUtil;
import kart.util.InputUtil;

//Admin menu will be keep displaying until exit.
public class AdminController {
	private static IAdminOperationsProduct productService = new AdminOperationsProductImpl();
	private static DateUtil date = new DateUtil();

	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean status = true;
		int id;
		String userName = "abcd123";
		String pass = "abcd123";
		System.out.println("Enter the ID and the password: ");
		userName = scanner.next();
		pass = scanner.next();

//Username/password validation
		if (productService.validate(userName, pass) == true) {
			System.out.println("ID and password matched!");
			while (status) {
				System.out.println("Welcome to the Operations");
				System.out.println(
						" 1. Enter product \n 2. Update product \n 3. Remove product \n 4. view Product \n 5. All Products \n 6. See All Customers \n 7. Exit");

				System.out.println("Enter your choice:");
				int choice = scanner.nextInt();

				switch (choice) {

				case 1:
					Product product = readProductInfo();
					if (productService.add(product)) {
						System.out.println("Product with product ID : " + product.getId() + " added successfully!");
					} else {
						System.out.println("Product not added!!");
					}
					break;

				case 2:
					System.out.println("Enter Product id : ");
					id = scanner.nextInt();
					if (productService.update(id) == true) {
						System.out.println("Product is updated sucessfully : ");
					} else
						System.out.println("Product does not exist!!");
					break;

				case 3:
					System.out.println("Enter the product id: ");
					id = scanner.nextInt();
					if (productService.delete(id) == true)
						System.out.println("Product is sucessfully deleted : ");
					else
						System.out.println("Product does not exist!!");
					break;

				case 4:
					System.out.println("Enter Product id : ");
					id = scanner.nextInt();
					if (productService.getProduct(id) == null) {
						System.out.println("Product does not exist : ");
					} else {
						Product obj1 = new Product();
						obj1 = productService.getProduct(id);
						System.out.println(" " + obj1.toString());
					}
					break;
				case 5:
					List<Product> list = productService.getAllProduct();
					Product obj2 = new Product();
					if (productService.getAllProduct() != null) {
						for (int i = 0; i < list.size(); i++) {
							obj2 = list.get(i);
							System.out.println(obj2.toString());
						}
					} else
						System.out.println("No Product in the list, add some Products first!!");
					break;
				case 6:
					CustomerDaoImpl cust = new CustomerDaoImpl();
					Object[] customers = cust.showCustomer();
					System.out.println(customers.length);

					for (int i = 0; i < customers.length; i++) {

						System.out.println(customers[i]);
					}
					break;
				case 7:
					status = false;
					break;
				default:
					System.out.println("Exiting the Admin section.");

				}

			}
		} else {
			System.out.println("Re-enter the credentials!! ");
			operations();
		}

	}

//read the product info
	private Product readProductInfo() {

		Scanner scanner = InputUtil.getScanner();
		System.out.println(
				"Enter Product id, name, price, qty, Manufacturing Date (dd-MM-yyyy), Expiry Date (dd-MM-yyyy): ");

		int id = scanner.nextInt();
		if (id < 1) {
			System.out.println("Enter valid Product Id ");
			readProductInfo();
		}
		String name = scanner.next();

		int price = scanner.nextInt();

		int quantity = scanner.nextInt();
		if (id < 1) {
			System.out.println("Quantity cannot be in negative ");
			readProductInfo();

		}

		String date1 = scanner.next();
		String date2 = scanner.next();

		Date mfd = date.getDate(date1);
		Date expiry = date.getDate(date2);
		return new Product(id, name, price, quantity, mfd, expiry);

	}

}
