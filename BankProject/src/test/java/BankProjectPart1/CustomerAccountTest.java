package BankProjectPart1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CustomerAccountTest {

	CustomerAccount c = new CustomerAccount("username", "password", "first name", "last name", 100.00, 100.00);

	@Test
	public void testCreation() {
		assertNotNull(c);
	}

	@Test
	public void testUsername() {
		assertEquals(c.getUsername(), "username");

		c.setUsername("SecretAgentMan");
		assertEquals(c.getUsername(), "SecretAgentMan");
	}

	@Test
	public void testPassword() {
		assertEquals(c.isPassword("password"), true);

		c.setPassword("1234");
		assertEquals(c.isPassword("1234"), true);
	}

	@Test
	public void testName() {
		assertEquals(c.getName(), "first name last name");

		c.setName("Bob", "Barker");
		assertEquals(c.getName(), "Bob Barker");
	}

	@Test
	public void testChecking() {
		assertEquals(c.getChecking(), 100.00);

		c.depositChecking(100.00);
		assertEquals(c.getChecking(), 200.00);

		c.withdrawChecking(50.00);
		assertEquals(c.getChecking(), 150.00);
	}

	@Test
	public void testSaving() {
		assertEquals(c.getSaving(), 100.00);

		c.depositSaving(100.00);
		assertEquals(c.getSaving(), 200.00);

		c.withdrawSaving(50.00);
		assertEquals(c.getSaving(), 150.00);
	}

	@Test
	public void testTransfer() {
		assertEquals(c.getChecking(), 100.00);
		assertEquals(c.getSaving(), 100.00);

		c.transferCtoS(50.00);
		assertEquals(c.getChecking(), 50.00);
		assertEquals(c.getSaving(), 150.00);

		c.transferStoC(100.00);
		assertEquals(c.getChecking(), 150.00);
		assertEquals(c.getSaving(), 50.00);

	}
}
