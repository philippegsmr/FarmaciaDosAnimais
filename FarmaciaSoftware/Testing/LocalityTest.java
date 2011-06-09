import static org.junit.Assert.*;

import org.junit.Test;


public class LocalityTest {

	@Test
	public void testLocality() {
		Locality loc = new Locality();
		assertEquals(loc.getCity(), "");
		assertEquals(loc.getCountry(), "");
		assertEquals(loc.getRegion(), "");
		assertEquals(loc.getState(), "");
	}

	@Test
	public void testLocalityStringStringStringString() {
		Locality loc1 = new Locality("United States of America", "Minnesota", "Minneapolis", "Dinkytown");
		assertEquals(loc1.getCity(), "Minneapolis");
		assertEquals(loc1.getCountry(), "United States of America");
		assertEquals(loc1.getRegion(), "Dinkytown");
		assertEquals(loc1.getState(), "Minnesota");
	}

	@Test
	public void testSetRegion() {
		Locality loc = new Locality();
		loc.setRegion("Passagem das Canoas");
		
		assertEquals(loc.getRegion(), "Passagem das Canoas");
	}

	@Test
	public void testSetCity() {
		Locality loc = new Locality();
		loc.setCity("Espinosa");
		assertEquals(loc.getCity(), "Espinosa");
	}

	@Test
	public void testSetState() {
		Locality loc = new Locality();
		loc.setState("Minas Gerais");
		assertEquals(loc.getState(), "Minas Gerais");
	}

	@Test
	public void testSetCountry() {
		Locality loc = new Locality();
		loc.setCountry("Brasil");
		assertEquals(loc.getCountry(), "Brasil");
	}

	@Test
	public void testGetCity() {
		Locality loc = new Locality();
		assertEquals(loc.getCity(), "");
		loc.setCity("Monte Azul");
		assertEquals(loc.getCity(), "Monte Azul");
	}

	@Test
	public void testGetState() {
		Locality loc = new Locality();
		assertEquals(loc.getState(), "");
		loc.setState("Bahia");
		assertEquals(loc.getState(), "Bahia");
	}

	@Test
	public void testGetCountry() {
		Locality loc = new Locality();
		assertEquals(loc.getCountry(), "");
		loc.setCountry("Germany");
		assertEquals(loc.getCountry(), "Germany");
	}

	@Test
	public void testGetRegion() {
		Locality loc = new Locality();
		assertEquals(loc.getRegion(), "");
		loc.setRegion("Sussuarana");
		assertEquals(loc.getRegion(), "Sussuarana");
	}

	@Test
	public void testFormatToString() {
		Locality loc = new Locality("Brasil", "Minas Gerais", "Espinosa", "Sussuarana");
		String l = loc.formatToString();
		assertEquals(l, "Sussuarana, Espinosa, Minas Gerais, Brasil");
	}

}
