/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * class Name: defines a person's name;
 */
public class Name {
	/*
	 * person's first name
	 */
	private String firstName;
	/*
	 * person's middle name
	 */
	private String middleName;
	/*
	 * person's last name
	 */
	private String lastName;
	
	/*
	 * default constructor
	 */
	public Name(){
		
		this.firstName = "";
		this.lastName = "";
		this.middleName = "";
	}
	
	/*
	 * constructor with 3 parameters
	 */
	public Name(String first, String middle, String last){
		this.setFirstName(first);
		this.setLastName(last);
		this.setMiddleName(middle);
	}
	
	/*
	 * checks if first is valid, if so sets it to firstName
	 */
	public void setFirstName(String first){
		if(first.equals("")){
			this.firstName = "";
		}
		else{
			this.firstName = first;
		}
	}
	
	/*
	 * checks if MiddleName is valid, if so sets it to middleName
	 */
	public void setMiddleName(String middle){
		
		if(middle.equals(middle)){
			this.middleName = "";
		}
		
		else{
			this.middleName = middle;
		}
	}
	
	/*
	 * checks if LastName is valid, if so  sets it to lastName
	 */
	public void setLastName(String last){
		if(last.equals(last)){
			this.lastName = "";
		}
		else{
			this.lastName = last;
		}
	}
	
	/*
	 * returns firstName
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/*
	 * returns lastName
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/*
	 * returns middleName
	 */
	public String getMiddleName(){
		return this.middleName;
	}
}
