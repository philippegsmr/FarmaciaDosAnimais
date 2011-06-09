/*
 * class Salary,
 * written by Philippe Ribeiro
 * Department of Computer Science, Univerity of Minnesota
 * Minneapolis, Minnesota, USA - 55545
 * 
 * the Class Salary, defines the Employee Salary
 * 
 * private:
 * 	double wage, defines the unity that the worker is going to be working
 *  int hoursPerWeek, defines the number of hours worked
 *  int paymentForm , defines how the worker is going to get paid
 *  final double OVERTIMERATE , in case of the employee is getting paid hourly, the overtime rate of 1.5 applies over 40 hours
 *  double salary, defines how the employee is going to get paid
 * 
 * class has been tested by Philippe Ribeiro
 * in June 8th, 2010
 */
public class Salary {
	/*
	 * defines the wage of the employee
	 */
	private double wage;
	/*
	 * defines how many hours per week does the employee work
	 */
	private double hoursPerWeek;

	/*
	 * defines the paymentFormat:
	 * 		1 - per Month
	 * 		2 - per hour
	 */
	private int paymentFormat;
	
	/*
	 * defines the overtime constant
	 */
	private final double OVERTIMERATE = 1.5;
	/*
	 * defines the amount received by the
	 * employee in a certain period of time
	 */
	private double salary;
	/*
	 * default constructor
	 */
	public Salary(){
		this.wage = 0;
		this.hoursPerWeek = 0;
		this.paymentFormat = 1;
	}
	
	/*
	 * overrode Constructor: takes three arguments
	 * the wage (double)
	 * the number of hours worked per week
	 * the paymentFormat;
	 * 
	 */
	public Salary(double wage, double hoursPerWeek, int paymentFormat){
		this.setPaymentFormat(paymentFormat);
		this.setWage(wage);
		this.setHoursPerWeek(hoursPerWeek);
	}

	/*
	 * checks if the number of hours worked is valid (between 0 and 168)
	 * then sets it to the field variable hoursPerWeek
	 * 
	 * else, sets it to 0
	 */
	public void setHoursPerWeek(double hoursPerWeek) {
		// TODO Auto-generated method stub
		if(hoursPerWeek >= 0  && hoursPerWeek <= 168){
			this.hoursPerWeek = hoursPerWeek;
		}
		else{
			this.hoursPerWeek = 0;
		}
		
	}

	/*
	 * sets the wage, it may be calculates monthly 
	 * or by hours
	 */
	public void setWage(double wage) {
		// TODO Auto-generated method stub
		if(wage >= 0){
			this.wage = wage;
		}
		else{
			this.wage = 0;
		}
		
	}

	/*
	 * sets how the employee is going to get paid
	 */
	public void setPaymentFormat(int paymentFormat) {
		// TODO Auto-generated method stub
		if(paymentFormat == 1 || paymentFormat == 2){
			this.paymentFormat = paymentFormat;
		}
		else{
			this.paymentFormat = 1;
		}
	}
	
	/*
	 * returns how the employee is going to get paid
	 */
	public int getPaymentFormat(){
		return this.paymentFormat;
	}
	/*
	 * returns the employee's number of hours worked
	 */
	public double getHoursPerWeek(){
		return this.hoursPerWeek;
	}
	/*
	 * return the employee's wage
	 */
	public double getWage(){
		return this.wage;
	}
	/*
	 * returns the employee salary
	 */
	public double getSalary(){
		
		/*
		 * if the employee receives monthly
		 * 
		 */
		if(this.paymentFormat == 1){
			this.salary = this.wage;
		}
		/*
		 * if the payment is per hour,
		 * so more it needs more calculations
		 */
		else{
			/*
			 * checks if the employee worked overtime
			 */
			if(this.hoursPerWeek > 40){
				double extraHours = this.hoursPerWeek - 40;
				this.salary = extraHours * ( this.OVERTIMERATE * this.wage) + this.wage * 40;
			}
			/*
			 * just regular pay
			 */
			else{
				this.salary = this.wage * this.hoursPerWeek;
			}
		}
		
		/*
		 * returns the salary
		 */
		return this.salary;
	}
	
	public String formatToString(){
		Double temp = this.getSalary();
		String salary = temp.toString();
		return salary;
	}
}
