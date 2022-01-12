package BankProjectPart1;

import java.util.Scanner;

public class CustomerConsole {
	private CustomerAccount login;
	private Scanner input = new Scanner(System.in);
	private Bank bank;

	public CustomerConsole(Bank b) {
		this.bank = b;
	}

	public void welcomeConsole() {
		int response = 0;

		System.out.println("Welcome to the banking app!");
		System.out.println("1: Login");
		System.out.println("2: Sign up");
		System.out.println("3: Exit");

		response = inputCheck.nextInt(input, 3);

		if (response == 1) {
			getLoginConsole();
		} else if (response == 2) {
			applicationCreationConsole();
		} else if (response == 0 || response == 3) {
			System.out.println("Exiting application.");
		} else {
			System.out.println("Invalid number, exiting application.");
		}
	}

	private void getLoginConsole() {
		String username, password;

		do {
			System.out.println("Enter Username:");
			username = input.nextLine();

			System.out.println("Enter Password:");
			password = input.nextLine();

			this.login = bank.getAccountC(username, password);
		} while (this.login == null);

		customerConsole();
	}

	private void applicationCreationConsole() {
		String username, password, fName, lName;
		double check, save;

		System.out.println("Enter Username:");
		username = input.nextLine();

		System.out.println("Enter Password:");
		password = input.nextLine();

		System.out.println("Enter First Name:");
		fName = input.nextLine();

		System.out.println("Enter Last Name:");
		lName = input.nextLine();

		System.out.println("Enter Initial Checking Deposit:");
		check = inputCheck.nextDouble(input); // error check for 2 precision double

		System.out.println("Enter Initial Savings Deposit:");
		save = inputCheck.nextDouble(input); // error check for 2 precision double

		bank.createApplicantC(username, password, fName, lName, check, save);
		System.out.println(
				"Thank you for applying for an account, please remember your Username: " + username + " and password: "
						+ password + " so you can login if your application is accepted. Have a great day!");

	}

	private void customerConsole() {
		int response;

		do {
			System.out.println("Welcome to your account, what would you like to do today?");
			System.out.println("1: View balance");
			System.out.println("2: Withdraw from account");
			System.out.println("3: Deposit to account");
			System.out.println("4: Transfer between accounts");
			System.out.println("5: Exit");
			response = inputCheck.nextInt(input, 5);

			switch (response) {
			case 1:
				System.out.println("Checking: " + login.getChecking());
				System.out.println("Savings: " + login.getSaving());
				break;
			case 2:
				System.out.println("Which account would you like to withdraw from?");
				System.out.println("1: Checking");
				System.out.println("2: Saving");
				int responseWithdraw = inputCheck.nextInt(input, 2);
				if (responseWithdraw == 1) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double withdrawC = inputCheck.nextDouble(input);
					if (!login.withdrawChecking(withdrawC))
						System.out.println("Withdraw from Checking failed!");
				}
				if (responseWithdraw == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double withdrawS = inputCheck.nextDouble(input);
					if (!login.withdrawSaving(withdrawS))
						System.out.println("Withdraw from Saving failed!");
				}
				break;
			case 3:
				System.out.println("Which account would you like to withdraw from?");
				System.out.println("1: Checking");
				System.out.println("2: Saving");
				int responseDeposit = inputCheck.nextInt(input, 2);
				if (responseDeposit == 1) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double depositC = inputCheck.nextDouble(input);
					if (!login.withdrawChecking(depositC))
						System.out.println("Withdraw from Checking failed!");
				}
				if (responseDeposit == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double depositS = inputCheck.nextDouble(input);
					if (!login.withdrawSaving(depositS))
						System.out.println("Withdraw from Saving failed!");
				}
				break;
			case 4:
				System.out.println("Which account would you like to transfer to?");
				System.out.println("1: Checking");
				System.out.println("2: Saving");
				int responseTransfer = inputCheck.nextInt(input, 2);
				if (responseTransfer == 1) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double moneyChangeStoC = inputCheck.nextDouble(input); // error check that input is a double, and 2
																			// precision
					if (!login.transferStoC(moneyChangeStoC))
						System.out.println("Money transfer failed!");
				}
				if (responseTransfer == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double moneyChangeCtoS = inputCheck.nextDouble(input); // error check that input is a double, and 2
																			// precision
					if (!login.transferCtoS(moneyChangeCtoS))
						System.out.println("Money transfer failed!");
				}
				break;
			}

		} while (response != 5);
	}
}
