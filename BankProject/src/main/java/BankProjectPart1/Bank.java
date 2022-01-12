package BankProjectPart1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private ArrayList<EmployeeAccount> accountsE = new ArrayList<EmployeeAccount>();
	private ArrayList<CustomerAccount> accountsC = new ArrayList<CustomerAccount>();
	private ArrayList<CustomerAccount> applicationsC = new ArrayList<CustomerAccount>();

	public Bank() {
		File accE = new File("src/main/resources/AccountsE.txt");
		File accC = new File("src/main/resources/AccountsC.txt");
		File appC = new File("src/main/resources/Applications.txt");
		String readLine;
		String[] splitLine;

		try {
			Scanner accEReader = new Scanner(accE);
			while (accEReader.hasNextLine()) {
				readLine = accEReader.nextLine();
				if (!readLine.equals("\n")) {
					splitLine = readLine.split(" ");
					accountsE.add(new EmployeeAccount(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
							Boolean.valueOf(splitLine[4])));
				}
			}
			accEReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("accountsE file not found.");
		}

		try {
			Scanner accCReader = new Scanner(accC);
			while (accCReader.hasNextLine()) {
				readLine = accCReader.nextLine();
				if (!readLine.equals("\n")) {
					splitLine = readLine.split(" ");
					accountsC.add(new CustomerAccount(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
							Double.valueOf(splitLine[4]), Double.valueOf(splitLine[5])));
				}
			}
			accCReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("accountsC file not found.");
		}

		try {
			Scanner appCReader = new Scanner(appC);
			while (appCReader.hasNextLine()) {
				readLine = appCReader.nextLine();
				if (!readLine.equals("\n")) {
					splitLine = readLine.split(" ");
					applicationsC.add(new CustomerAccount(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
							Double.valueOf(splitLine[4]), Double.valueOf(splitLine[5])));
				}
			}
			appCReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("applications file not found.");
		}
	}

	public CustomerAccount getAccountC(String username, String password) {
		int acc = -1;
		for (int i = 0; i < accountsC.size(); i++) {
			if (accountsC.get(i).getUsername().equals(username))
				acc = i;
		}
		if (acc == -1) {
			System.out.println("Username not found!");
			return null;
		}

		if (accountsC.get(acc).isPassword(password)) {
			System.out.println("Login successful");
			return accountsC.get(acc);
		} else {
			System.out.println("Password was incorrect!");
			return null;
		}
	}

	public EmployeeAccount getAccountE(String username, String password) {
		int acc = -1;
		for (int i = 0; i < accountsE.size(); i++) {
			if (accountsE.get(i).getUsername().equals(username))
				acc = i;
		}
		if (acc == -1) {
			System.out.println("Username not found!");
			return null;
		}

		if (accountsE.get(acc).isPassword(password)) {
			System.out.println("Login successful");
			return accountsE.get(acc);
		} else {
			System.out.println("Password was incorrect!");
			return null;
		}
	}

	public CustomerAccount getAccountC(int i) {
		if ((i - 1) < accountsC.size())
			return accountsC.get(i - 1);
		else
			return null;
	}

	public EmployeeAccount getAccountE(int i) {
		if ((i - 1) < accountsE.size())
			return accountsE.get(i - 1);
		else
			return null;
	}

	public void createAccountE(String username, String password, String fName, String lName, boolean admin) {
		accountsE.add(new EmployeeAccount(username, password, fName, lName, admin));
	}

	public void createApplicantC(String username, String password, String fName, String lName, double initCheck,
			double initSave) {
		applicationsC.add(new CustomerAccount(username, password, fName, lName, initCheck, initSave));
	}

	public void acceptApplicantC(int i) {
		if ((i - 1) < applicationsC.size()) {
			accountsC.add(applicationsC.get(i - 1));
			applicationsC.remove(i - 1);
		} else
			System.out.println("Out of bounds, failed to accept.");
	}

	public void declineApplicantC(int i) {
		if ((i - 1) < applicationsC.size())
			applicationsC.remove(i - 1);
		else
			System.out.println("Out of bounds, failed to decline.");
	}

	public boolean deleteAccountC(int i) {
		if ((i - 1) < accountsC.size()) {
			accountsC.remove(i - 1);
			return true;
		} else
			return false;
	}

	public boolean deleteAccountE(int i) {
		if ((i - 1) < accountsE.size()) {
			accountsE.remove(i - 1);
			return true;
		} else
			return false;
	}

	public void viewAccountsC() {
		for (int i = 0; i < accountsC.size(); i++) {
			System.out.println((i + 1) + " " + accountsC.get(i).getName() + " Checkings: "
					+ accountsC.get(i).getChecking() + " , Savings: " + accountsC.get(i).getSaving());
		}
	}

	public void viewAccountsE() {
		for (int i = 0; i < accountsE.size(); i++) {
			System.out.println(
					(i + 1) + " " + accountsE.get(i).getName() + " Administrator: " + accountsE.get(i).getAdmin());
		}
	}

	public void viewApplicationsC() {
		for (int i = 0; i < applicationsC.size(); i++) {
			System.out.println((i + 1) + " " + applicationsC.get(i).getName() + " Checkings: "
					+ applicationsC.get(i).getChecking() + " , Savings: " + applicationsC.get(i).getSaving());
		}
	}

	@Override
	public void finalize() {
		try {
			FileWriter applicationsCWriter = new FileWriter("src/main/resources/Applications.txt");
			for (int i = 0; i < applicationsC.size(); i++) {
				applicationsCWriter.write(applicationsC.get(i).save() + "\n");
			}
			applicationsCWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
		try {
			FileWriter accountsCWriter = new FileWriter("src/main/resources/AccountsC.txt");
			for (int i = 0; i < accountsC.size(); i++) {
				accountsCWriter.write(accountsC.get(i).save() + "\n");
			}
			accountsCWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
		try {
			FileWriter accountsEWriter = new FileWriter("src/main/resources/AccountsE.txt");
			for (int i = 0; i < accountsE.size(); i++) {
				accountsEWriter.write(accountsE.get(i).save() + "\n");
			}
			accountsEWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
}
