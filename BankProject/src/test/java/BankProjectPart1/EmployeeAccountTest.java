package BankProjectPart1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class EmployeeAccountTest {

	EmployeeAccount e = new EmployeeAccount("username", "password", "first name", "last name", true);

	@Test
	public void testCreation() {
		assertNotNull(e);
	}

	@Test
	public void testUsername() {
		assertEquals(e.getUsername(), "username");

		e.setUsername("SecretAgentMan");
		assertEquals(e.getUsername(), "SecretAgentMan");
	}

	@Test
	public void testPassword() {
		assertEquals(e.isPassword("password"), true);

		e.setPassword("1234");
		assertEquals(e.isPassword("1234"), true);
	}

	@Test
	public void testName() {
		assertEquals(e.getName(), "first name last name");

		e.setName("Bob", "Barker");
		assertEquals(e.getName(), "Bob Barker");
	}

	@Test
	public void testAdmin() {
		assertEquals(e.getAdmin(), true);

		e.setAdmin(false);
		assertEquals(e.getAdmin(), false);
	}

}
