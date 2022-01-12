package BankProjectPart1;

import java.util.Scanner;

public class EmployeeConsole {
	private EmployeeAccount login;
	private Scanner input = new Scanner(System.in);
	private Bank bank;

	public EmployeeConsole(Bank b) {
		this.bank = b;
	}

	public void getLoginConsole() {
		String username, password;

		do {
			System.out.println("Enter Username:");
			username = input.nextLine();

			System.out.println("Enter Password:");
			password = input.nextLine();

			this.login = bank.getAccountE(username, password);
		} while (this.login == null);

		if (login.getAdmin())
			adminConsole();
		else
			employeeConsole();

	}

	private void adminConsole() {
		int response;

		do {
			System.out.println("Admin Console:");
			System.out.println("1: view all customer accounts");
			System.out.println("2: select account");
			System.out.println("3: delete account");
			System.out.println("4: view applicants");
			System.out.println("5: accept applicant");
			System.out.println("6: deline applicant");
			System.out.println("7: view all employee accounts");
			System.out.println("8: create employee account");
			System.out.println("9: change employee admin");
			System.out.println("10: delete employee account");
			System.out.println("11: exit");

			response = inputCheck.nextInt(input, 11);

			switch (response) {
			case 1:
				bank.viewAccountsC();
				System.out.println("Enter to return to console:");
				input.nextLine();
				break;
			case 2:
				System.out.println("Enter account number:");
				int customerIndexV = inputCheck.nextInt(input, 0);
				CustomerAccount view = bank.getAccountC(customerIndexV);
				if (view != null)
					accountEditorConsole(view);
				else {
					System.out.println("Account retrieval failed!");
					System.out.println("Enter to return to console:");
					input.nextLine();
				}
				break;
			case 3:
				System.out.println("Enter account number:");
				int customerIndexD = inputCheck.nextInt(input, 0);
				if (!bank.deleteAccountC(customerIndexD)) {
					System.out.println("Account deletion failed!");
					System.out.println("Enter to return to console:");
					input.nextLine();
				}
				break;
			case 4:
				bank.viewApplicationsC();
				System.out.println("Enter to return to console:");
				input.nextLine();
				break;
			case 5:
			case 6:
				System.out.println("Enter applicant number:");
				int applicantIndex = inputCheck.nextInt(input, 0);
				if (response == 5)
					bank.acceptApplicantC(applicantIndex);
				if (response == 6)
					bank.declineApplicantC(applicantIndex);
				break;
			case 7:
				bank.viewAccountsE();
				System.out.println("Enter to return to console:");
				input.nextLine();
				break;
			case 8:
				accountECreationConsole();
				break;
			case 9:
				System.out.println("Enter account number:");
				int employeeIndexE = inputCheck.nextInt(input, 0);
				EmployeeAccount editAdmin = bank.getAccountE(employeeIndexE);
				boolean newAdmin;
				if (editAdmin != null) {
					System.out.println("Enter admin value: (true or false)");
					newAdmin = inputCheck.nextBoolean(input);
					editAdmin.setAdmin(newAdmin);
				}
				break;
			case 10:
				System.out.println("Enter account number:");
				int employeeIndexD = inputCheck.nextInt(input, 0);
				if (!bank.deleteAccountE(employeeIndexD)) {
					System.out.println("Account deletion failed!");
					System.out.println("Enter to return to console:");
					input.nextLine();
				}
				break;
			}
		} while (response != 11);
	}

	private void accountECreationConsole() {
		String username, password, fName, lName;
		boolean admin;

		System.out.println("Enter Username:");
		username = input.nextLine();

		System.out.println("Enter Password:");
		password = input.nextLine();

		System.out.println("Enter First Name:");
		fName = input.nextLine();

		System.out.println("Enter Last Name:");
		lName = input.nextLine();

		System.out.println("Is the account for an admin: (true or false)");
		admin = inputCheck.nextBoolean(input);

		bank.createAccountE(username, password, fName, lName, admin);
	}

	private void accountEditorConsole(CustomerAccount a) {
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
				System.out.println("Checking: " + a.getChecking());
				System.out.println("Savings: " + a.getSaving());
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
					if (!a.withdrawChecking(withdrawC))
						System.out.println("Withdraw from Checking failed!");
				}
				if (responseWithdraw == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double withdrawS = inputCheck.nextDouble(input);
					if (!a.withdrawSaving(withdrawS))
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
					if (!a.withdrawChecking(depositC))
						System.out.println("Withdraw from Checking failed!");
				}
				if (responseDeposit == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double depositS = inputCheck.nextDouble(input);
					if (!a.withdrawSaving(depositS))
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
					double moneyChangeStoC = inputCheck.nextDouble(input);
					if (!a.transferStoC(moneyChangeStoC))
						System.out.println("Money transfer failed!");
				}
				if (responseTransfer == 2) {
					System.out
							.println("Money will be withdrawn from savings and deposited into checking. Enter amount:");
					double moneyChangeCtoS = inputCheck.nextDouble(input);
					if (!a.transferCtoS(moneyChangeCtoS))
						System.out.println("Money transfer failed!");
				}
				break;
			}

		} while (response != 5);
	}

	private void employeeConsole() {
		bank.viewAccountsC();
		System.out.println("Enter to exit...");
		input.nextLine();
	}

}
