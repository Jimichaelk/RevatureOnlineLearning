package BankProjectPart1;

public class EmployeeAccount {
	private String fName, lName, username, password;
	private boolean admin;

	public EmployeeAccount(String u, String p, String f, String l, boolean a) {
		this.username = u;
		this.password = p;
		this.fName = f;
		this.lName = l;
		this.admin = a;
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

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean a) {
		this.admin = a;
	}

	public String save() {
		return username + " " + password + " " + fName + " " + lName + " " + String.valueOf(admin);
	}
}
