import static org.junit.Assert.*;

import org.junit.Test;


public class SalaryTest {

	@Test
	public void testSalary() {
		Salary salary = new Salary();
		assertEquals(0, salary.getHoursPerWeek(), 0.001);
		assertEquals(0, salary.getSalary(), 0.01);
		assertEquals(1, salary.getPaymentFormat());
	}

	@Test
	public void testSalaryDoubleIntInt() {
		Salary salary = new Salary(545, 40, 1);
		assertEquals(40, salary.getHoursPerWeek(), 0.01);
		assertEquals(545, salary.getWage(), 0.01);
		assertEquals(545, salary.getSalary(), 0.01);
		assertEquals(1, salary.getPaymentFormat());
		
		Salary salary2 = new Salary(13.28, 40, 2);
		assertEquals(40, salary2.getHoursPerWeek(), 0.01);
		assertEquals(531.2, salary2.getSalary(), 0.1);
		assertEquals(13.28, salary2.getWage(), 0.1);
		assertEquals(2, salary2.getPaymentFormat());
		
		Salary salary3 = new Salary(13, 50, 3);
		assertEquals(50, salary3.getHoursPerWeek(), 0.001);
		assertEquals(13, salary3.getSalary(), 0.01);
		assertEquals(1, salary3.getPaymentFormat());
		
		Salary salary4 = new Salary(11, 50, 2);
		assertEquals(50, salary4.getHoursPerWeek(), 0.001);
		assertEquals(605, salary4.getSalary(), 0.01);
		assertEquals(2, salary4.getPaymentFormat());
		assertEquals(11, salary4.getWage(), 0.01);
		
		Salary salary5 = new Salary(-11, 50, 2);
		assertEquals(50, salary5.getHoursPerWeek(), 0.001);
		assertEquals(0, salary5.getSalary(), 0.01);
		assertEquals(2, salary5.getPaymentFormat());
	}

	@Test
	public void testSetHoursPerWeek() {
		Salary salary1 = new Salary();
		salary1.setHoursPerWeek(50);
		assertEquals(salary1.getHoursPerWeek(), 50, 0.01);
		
		Salary salary2 = new Salary();
		salary2.setHoursPerWeek(-2);
		assertEquals(0, salary2.getHoursPerWeek(), 0.01);
	}

	@Test
	public void testSetWage() {
		Salary salary1 = new Salary();
		salary1.setWage(11.65);
		assertEquals(11.65, salary1.getSalary(), 0.01);
		
		Salary salary2 = new Salary();
		salary2.setWage(-1.45);
		assertEquals(0, salary2.getWage(), 0.01);
	}

	@Test
	public void testSetPaymentFormat() {
		Salary salary1 = new Salary();
		salary1.setPaymentFormat(2);
		assertEquals(2, salary1.getPaymentFormat());
		
		salary1.setPaymentFormat(3);
		assertEquals(1, salary1.getPaymentFormat());
		
		salary1.setPaymentFormat(-1);
		assertEquals(1, salary1.getPaymentFormat());
		
	}

	@Test
	public void testGetPaymentFormat() {
		Salary salary1 = new Salary();
		salary1.setPaymentFormat(2);
		assertEquals(2, salary1.getPaymentFormat());
	}

	@Test
	public void testGetHoursPerWeek() {
		Salary salary1 = new Salary();
		salary1.setHoursPerWeek(50);
		assertEquals(salary1.getHoursPerWeek(), 50, 0.01);
	}

	@Test
	public void testGetWage() {
		Salary salary1 = new Salary();
		salary1.setWage(11.65);
		assertEquals(11.65, salary1.getSalary(), 0.01);
		
	}

	@Test
	public void testGetSalary() {
		Salary salary1 = new Salary(21, 40, 2);
		assertEquals(840, salary1.getSalary(), 0.01);
		
		Salary salary2 = new Salary(21, 45.5, 2);
		assertEquals(1013.25, salary2.getSalary(), 0.01);
		
		Salary salary3 = new Salary(-10, 50, 2);
		assertEquals(0, salary3.getSalary(), 0.01);
		
		Salary salary4 = new Salary(600, 40, 1);
		assertEquals(600, salary4.getSalary(), 0.01);
		
		Salary salary5 = new Salary(600, 50, 1);
		assertEquals(600, salary5.getSalary(), 0.01);
		
		Salary salary6 = new Salary(-200, 40, 1);
		assertEquals(0, salary6.getSalary(), 0.01);
	}

	@Test
	public void testFormatToString() {
		Salary salary4 = new Salary(600, 40, 1);
		String s = salary4.formatToString();
		assertEquals("600.0", s);
	}

}
