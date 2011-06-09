import static org.junit.Assert.*;

import org.junit.Test;


public class NameTest {

	@Test
	public void testName() {
		Name name = new Name();
		assertEquals(name.getFirstName(), "");
		assertEquals(name.getLastName(), "");
		assertEquals(name.getLastName(), "");
	}

	@Test
	public void testNameStringStringString() {
		Name name = new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro");
		assertEquals(name.getFirstName(), "Philippe");
		assertEquals(name.getLastName(), "Souza Moraes Ribeiro");
		assertEquals(name.getMiddleName(), "Gabriel");
	}

	@Test
	public void testSetFirstName() {
		Name name = new Name();
		name.setFirstName("Gabriela");
		assertEquals(name.getFirstName(), "Gabriela");
	}

	@Test
	public void testSetMiddleName() {
		Name name = new Name();
		name.setMiddleName("Rocha");
		assertEquals(name.getMiddleName(), "Rocha");
	}

	@Test
	public void testSetLastName() {
		Name name = new Name();
		name.setLastName("Doe");
		assertEquals(name.getLastName(), "Doe");
	}

	@Test
	public void testFormatToString() {
		Name name = new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro");
		String n = name.formatToString();
		assertEquals(n, "Philippe Gabriel Souza Moraes Ribeiro");
	}

}
