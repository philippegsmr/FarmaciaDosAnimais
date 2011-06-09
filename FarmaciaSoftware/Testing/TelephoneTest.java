import static org.junit.Assert.*;
/*
 * class Telephone tested by Philippe Ribeiro
 * June 6th, 2011
 * 
 */

import org.junit.Test;


public class TelephoneTest {

	@Test
	public void testTelephone() {
		Telephone telephone = new Telephone();
		assertEquals(telephone.getTelephone(), "");
		assertEquals(telephone.getTelephoneCountry(), "");
	}

	@Test
	public void testTelephoneStringString() {
		Telephone tel1 = new Telephone("3838121453", "Brasil");
		assertEquals(tel1.getTelephone(), "(38) 3812-1453");
		Telephone tel2 = new Telephone("6129658329", "United States of America");
		assertEquals(tel2.getTelephone(), "(612) 965-8329");
	}

	@Test
	public void testSetTelephoneBrazilFormat() {
		Telephone tel1 = new Telephone("3838121453", "Brasil");
		assertEquals(tel1.getTelephone(), "(38) 3812-1453");
		
		Telephone tel2 = new Telephone("123456789", "Brasil");
		assertEquals(tel2.getTelephone(), "");
	}

	@Test
	public void testSetTelephoneUSAFormat() {
		Telephone tel2 = new Telephone("6129658329", "United States of America");
		assertEquals(tel2.getTelephone(), "(612) 965-8329");
		
		Telephone tel3 = new Telephone("612965832", "United States of America");
		assertEquals(tel3.getTelephone(), "");
	}

	@Test
	public void testSetTelephoneCountry() {
		Telephone tel = new Telephone();
		tel.setTelephoneCountry("Brasil");
		assertEquals(tel.getTelephoneCountry(), "Brasil");
	}

	@Test
	public void testGetTelephoneCountry() {
		Telephone tel2 = new Telephone("6129658329", "United States of America");
		assertEquals(tel2.getTelephoneCountry(), "United States of America");
	}

	@Test
	public void testGetTelephone() {
		Telephone tel2 = new Telephone("6129658329", "United States of America");
		assertEquals(tel2.getTelephone(), "(612) 965-8329");
	}

}
