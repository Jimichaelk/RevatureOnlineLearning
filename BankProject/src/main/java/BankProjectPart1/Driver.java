package BankProjectPart1;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		// create logger here
		// create console with logger

		// launch console

		Bank bank = new Bank();
		int response = 0;

		System.out.println("Select login account type: ");
		System.out.println("1: Customer");
		System.out.println("2: Employee");
		response = inputCheck.nextInt(new Scanner(System.in), 2);

		if (response == 1) {
			CustomerConsole c = new CustomerConsole(bank);
			c.welcomeConsole();
		}
		if (response == 2) {
			EmployeeConsole e = new EmployeeConsole(bank);
			e.getLoginConsole();
		}

		bank.finalize();
		System.out.println("Exited successfully!");

	}
}
