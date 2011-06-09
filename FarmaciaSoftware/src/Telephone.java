/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * the class Telephone takes a String such as 1234567890
 * and formats it into 123-456-7890 in US format or 
 * 12 - 3456 - 7890 in Brazil format
 */


public class Telephone {
	
	private String telephone;
	private String country;
	
	/*
	 * default constructor
	 */
	public Telephone(){
		this.telephone = "";
		this.country = "";
	}
	
	/*
	 * USA has a format xxx-xxx-xxxx for telephones
	 * Brazil has a format xx - xxxx - xxxx for telephones
	 */
	public Telephone(String telephone, String country){
		
		/*
		 * checks if country = brasil
		 */
		if(country.equals("Brasil")){
			this.setTelephoneBrazilFormat(telephone);
		}
		/*
		 * now it is supporting two countries only
		 */
		else if(country.equals("United States of America")){
			this.setTelephoneUSAFormat(telephone);
		}
		else{
			System.out.println("Error");
		}
		
		this.setTelephoneCountry(country);
	}
	
	/*
	 * input is a flat string number, as xxxxxxxxx
	 * perhaps we should check the string's length; 
	 * regular expression formats the telephone to the xx - xxxx - xxxx format
	 */
	public void setTelephoneBrazilFormat(String phoneNumber){
		if(phoneNumber.length() >= 10){
			//return String.format("(%03d) %03d-%04d", area, exch, ext);
			 String fNum = null;
			 phoneNumber.replaceAll("[^0-9]", "");
			 
			    if(12 == phoneNumber.length())
			    {
			        fNum = "+" + phoneNumber.substring(0, 2);
			        fNum += " (" + phoneNumber.substring(2, 4) + ")";
			        fNum += " " + phoneNumber.substring(4, 8);
			        fNum += "-" + phoneNumber.substring(8, 12);
			    }
			    else if(10 == phoneNumber.length())
			    {
			        fNum = "(" + phoneNumber.substring(0, 2) + ")";
			        fNum += " " + phoneNumber.substring(2, 6);
			        fNum += "-" + phoneNumber.substring(6, 10);
			    }
			  
			    else
			    {
			        System.out.println("Invalid Phone Number.");
			        this.telephone = "";
			    }
			 
			    this.telephone = fNum;
			    
		}
		else{
			this.telephone = "";
		}
	}
	
	/*
	 * regular expression formats the telephone to the xxx-xxx-xxx format
	 */
	public void setTelephoneUSAFormat(String phoneNumber){
		if(phoneNumber.length() >= 10){
			//return String.format("(%03d) %03d-%04d", area, exch, ext);
			 String fNum = null;
			 phoneNumber.replaceAll("[^0-9]", "");
			 
			    if(11 == phoneNumber.length())
			    {
			        fNum = "+" + phoneNumber.substring(0, 1);
			        fNum += " (" + phoneNumber.substring(1, 4) + ")";
			        fNum += " " + phoneNumber.substring(4, 7);
			        fNum += "-" + phoneNumber.substring(7, 11);
			    }
			    else if(10 == phoneNumber.length())
			    {
			        fNum = "(" + phoneNumber.substring(0, 3) + ")";
			        fNum += " " + phoneNumber.substring(3, 6);
			        fNum += "-" + phoneNumber.substring(6, 10);
			    }
			    else
			    {
			       System.out.println("Invalid Phone Number.");
			       this.telephone = "";
			    }
			 
			    this.telephone = fNum;
			    
		}
		else{
			this.telephone = "";
		}
	}
	
	public void setTelephoneCountry(String country){
		this.country = country;
	}
	
	/*
	 * return the country of the telephone number;
	 */
	public String getTelephoneCountry(){
		return this.country;
	}
	/*
	 * returns the telephone formatted
	 */
	public String getTelephone(){
		return this.telephone;
	}

}
