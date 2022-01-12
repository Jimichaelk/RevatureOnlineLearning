package BankProjectPart1;

import java.util.Scanner;

public class inputCheck {
	public static int nextInt(Scanner s, int limit) {
		int response;
		boolean exception = false;
		try {
			response = s.nextInt();
			s.nextLine();
		} catch (Exception e) {
			System.out.println("Could not convert user input to a valid option.");
			s.nextLine();
			response = 0;
			exception = true;
		}
		if (((response > limit && limit != 0) || response < 1) && !exception) {
			System.out.println("User input was outside the expected range.");
			return 0;
		} else {
			return response;
		}
	}

	public static double nextDouble(Scanner s) {
		double response;
		try {
			response = s.nextDouble();
			s.nextLine();
		} catch (Exception e) {
			System.out.println("Could not convert user input to a valid option.");
			s.nextLine();
			response = 0.00;
		}
		if (response < 0.00) {
			System.out.println("Negative amounts of money are invalid.");
			return 0.00;
		} else {
			return precisionTwo(response);
		}
	}

	public static double precisionTwo(double d) {
		if (d * 100 > (double) (int) (d * 100)) {
			d = ((double) (int) (d * 100)) / 100;
			System.out.println("Input had too many digits, it has been modified to: " + d);
		}
		return d;
	}

	public static boolean nextBoolean(Scanner s) {
		boolean response;
		try {
			response = s.nextBoolean();
			s.nextLine();
			return response;
		} catch (Exception e) {
			System.out.println("Could not convert user input to a valid option, default value of false will be use.");
			return false;
		}
	}
}
