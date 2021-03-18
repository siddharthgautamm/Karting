package kart.util;

import java.util.Scanner;

public class InputUtil {

	private static Scanner scanner = null;

	public static Scanner getScanner() {

		if (null == scanner)
			return new Scanner(System.in);
		else
			return scanner;
	}
}
