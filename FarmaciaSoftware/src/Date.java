/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * class Date, defines a date in the format mm / day / year
 */
public class Date {

	/*
	 * defines a day
	 */
	private int day;
	/*
	 * defines a month
	 */
	private int month;
	/*
	 * defines a year
	 */
	private int year;
	
	/*
	 * default constructor
	 */
	public Date(){
		
		this.day = 1;
		this.month = 1;
		this.year = 1900;
	}
	/*
	 * constructor with 3 parameters
	 */
	public Date(int month, int day, int year){
		
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}
	/*
	 * checks if day is between 1 and 31
	 * if so, sets it to day, otherwise assigns default
	 */
	public void setDay(int day){
		if(day >= 1 && day <= 31){
			this.day = day;
		}
		else{
			this.day = 1;
		}
	}
	/*
	 * checks if month is between 1 and 12
	 * if so, sets it to month, otherwise assigns default
	 */
	public void setMonth(int month){
		
		if(month >= 1 && month <= 12){
			this.month = month;
		}
		else{
			this.month = 1;
		}
	}
	
	/*
	 * checks if year is after 1900 and before 2100
	 * if so, sets it to year
	 */
	public void setYear(int year){
		if(year >= 1900 && year <= 2100){
			this.year = year;
		}
		else{
			this.year = 1900;
		}
	}
	
	/*
	 * returns day
	 */
	public int getDay(){
		return this.day;
	}
	
	/*
	 * returns month
	 */
	public int getMonth(){
		return this.month;
	}
	
	/*
	 * returns year
	 */
	public int getYear(){
		return this.year;
	}
	
	/*
	 * outputs in the format mm / dd / yy
	 */
	public void printDate(){
		String date = this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
		System.out.println(date);
	}
	
	public String formatToString(){
		String output = this.getMonth() + "/" + this.getDay() + "/" + this.getYear() + "\n";
		return output;
	}
}
