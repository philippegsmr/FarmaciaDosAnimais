/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * class Locality defines a geographical locality
 * mostly used into the class Address
 * e.g Capivara, Espinosa, Minas Gerais, Brazil
 * 
 * private String country: the country name e.g: Unites States
 * private String state: the state name e.g: Minnesota
 * private String city: the city's name e.g: Minneapolis
 * private string Region: a region name: e.g: Dinkytown
 * 
 * class has been tested in June 8th, 2011
 */
public class Locality {

	/*
	 * defines the country's name
	 */
	private String country;
	/*
	 * defines the state's name
	 */
	private String state;
	/*
	 * defines the city's name
	 */
	private String city;
	/*
	 * defines the region's name
	 */
	private String region;
	
	/*
	 * default constructor
	 */
	public Locality(){
		this.city = "";
		this.country = "";
		this.region = "";
		this.state = "";
	}
	
	/*
	 * constructor with 4 arguments
	 * calls each field variables' set function
	 */
	public Locality(String country, String state, String city, String region){
			this.setCountry(country);
			this.setState(state);
			this.setCity(city);
			this.setRegion(region);
	}

	/*
	 * set the region
	 */
	public void setRegion(String region) {
		// TODO Auto-generated method stub
		this.region = region;
	}

	/*
	 * sets the city
	 */
	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;
	}

	/*
	 * sets the state
	 */
	public void setState(String state) {
		// TODO Auto-generated method stub
		this.state = state;
		
	}

	/*
	 * set the country
	 */
	public void setCountry(String country) {
		// TODO Auto-generated method stub
		this.country = country;
		
	}
	
	/*
	 * returns the city : String
	 */
	public String getCity(){
		return this.city;
	}
	
	/*
	 * returns the state: String
	 */
	public String getState(){
		return this.state;
	}
	
	/*
	 * returns the country: String
	 */
	public String getCountry(){
		return this.country;
	}
	
	/*
	 * sets the region: String
	 */
	public String getRegion(){
		return this.region;
	}
	
	/*
	 * returns locality in the format " Dinkytown, Minneapolis, Minnesota, USA
	 */
	public String formatToString(){
		String locality = this.getRegion() + ", " + this.getCity() + ", " + this.getState() + ", " + this.getCountry();
		return locality;
	}
}
