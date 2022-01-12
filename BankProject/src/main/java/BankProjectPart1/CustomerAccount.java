package BankProjectPart1;

public class CustomerAccount {
	private String fName, lName, username, password;
	private double checking, saving;

	public CustomerAccount(String u, String p, String f, String l, double c, double s) {
		this.username = u;
		this.password = p;
		this.fName = f;
		this.lName = l;
		this.checking = c;
		this.saving = s;
	}

	public String getName() {
		return fName + " " + lName;
	}

	public void setName(String fN, String lN) {
		this.fName = fN;
		this.lName = lN;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public boolean isPassword(String pass) {
		return this.password.equals(pass);
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public double getChecking() {
		return checking;
	}

	public double getSaving() {
		return saving;
	}

	public void newBalance() {
		System.out.println("New balance is Checking: " + checking + "  Saving: " + saving);
	}

	public boolean depositChecking(double d) {
		if (d == 0.00)
			return false;
		else {
			checking += d;
			newBalance();
			return true;
		}
	}

	public boolean withdrawChecking(double d) {
		if (d == 0.00)
			return false;
		if ((checking - d) >= 0.00) {
			checking -= d;
			newBalance();
			return true;
		} else
			return false;
	}

	public boolean depositSaving(double d) {
		if (d == 0.00)
			return false;
		else {
			saving += d;
			newBalance();
			return true;
		}
	}

	public boolean withdrawSaving(double d) {
		if (d == 0.00)
			return false;
		if ((saving - d) >= 0.00) {
			saving -= d;
			newBalance();
			return true;
		} else
			return false;
	}

	public boolean transferCtoS(double m) {
		if (m == 0.00)
			return false;
		if ((checking - m) >= 0.00) {
			checking -= m;
			saving += m;
			newBalance();
			return true;
		} else
			return false;
	}

	public boolean transferStoC(double m) {
		if (m == 0.00)
			return false;
		if ((saving - m) >= 0.00) {
			saving -= m;
			checking += m;
			newBalance();
			return true;
		} else
			return false;
	}

	public String save() {
		return username + " " + password + " " + fName + " " + lName + " " + String.valueOf(checking) + " "
				+ String.valueOf(saving);
	}
}
