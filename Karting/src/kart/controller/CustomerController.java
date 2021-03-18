package kart.controller;

import kart.service.ICustomerOperations;
import kart.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kart.model.Customer;
import kart.model.Product;
import kart.service.CustomerOperationsImpl;

//Customer menu will be displayed until exit.
public class CustomerController {
	private static ICustomerOperations customerService = new CustomerOperationsImpl();

	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean status = true;
		int id;
		Long cust = new Long(0);

		while (status) {
			System.out.println("Welcome to Customer Operations");
			System.out.println(
					" 1. Self Register \n 2. View Non-Expired Products \n 3. Add product to the cart \n 4. view the cart \n 5. Exit");

			System.out.println("enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				Customer customer = readCustomerInfo();
				if (customerService.register(customer)) {
					System.out.println("Customer with customer ID: " + customer.getId() + " added successfully!");
				} else {
					System.out.println("Customer not added!");
				}
				cust = customer.getId();

				break;

			case 2:
				System.out.println("The following are the non expired products : ");
				List<Product> list = customerService.view();
				Product obj2 = new Product();

				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						obj2 = list.get(i);
						System.out.println(obj2);
					}
				} else
					System.out.println("No non expired product available");

				break;

			case 3:
				System.out.println("Enter Product Id to be entered in the cart: ");
				id = scanner.nextInt();
				int custId = cust.intValue();
				if (custId == 0) {
					System.out.println("Enter Customer Id: ");
					custId = scanner.nextInt();
				}
				if (customerService.add(id, custId) == true)
					System.out.println("Product is sucessfully Added: ");
				else
					System.out.println("Product does not exist");
				break;

			case 4:
				int c = cust.intValue();
				if (c == 0) {
					System.out.println("Enter Customer Id: ");
					c = scanner.nextInt();
				}
				if (customerService.viewCart(c).size() == 0) {
					System.out.println("Cart is empty: ");
				} else {
					List<Product> cartList = new ArrayList<Product>();
					cartList = customerService.viewCart(c);
					for (int i = 0; i < cartList.size(); i++)
						System.out.println(" " + cartList.get(i));
				}
				break;
			case 5:
				status = false;
				System.out.println("Exiting Customer section....");
				break;
			default:
				System.out.println("Enter a valid choice");

			}

		}

	}

	// read customer info
	private Customer readCustomerInfo() {

		Scanner scanner = InputUtil.getScanner();
		System.out.println("Enter id, name, email, phone, address");
		int id = scanner.nextInt();
		String name = scanner.next();
		String email = scanner.next();
		Long phone = scanner.nextLong();
		String address = scanner.next();

		Customer customer = new Customer(id, name, email, phone, address);
		return customer;
	}

}

