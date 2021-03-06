
public class Company {
	
	private String name;
	private String identificationNumber;
	private Address address;
	private Telephone telephone;
	private Integer companyId;
	
	public Company(){
		this.name = "";
		this.identificationNumber = "";
		this.address = new Address();
		this.telephone = new Telephone();
		this.companyId = 0;
	}
	
	public Company(String name, String id, Address address, Telephone telephone){
		this.setCompanyName(name);
		this.setCompanyIdentificationNumber(id);
		this.setCompanyAddress(address);
		this.setCompanyTelephone(telephone);
	}

	public void setCompanyTelephone(Telephone telephone) {
		// TODO Auto-generated method stub
		this.telephone = telephone;
	}

	public void setCompanyAddress(Address address) {
		// TODO Auto-generated method stub
		this.address = address;
	}
	
	public void setCompanyId(Integer id){
		if(id > 0){
			this.companyId = id;
		}
		else{
			this.companyId = 0;
		}
	}
	/*
	 * needs to have a regular expression to format it correctly
	 */
	public void setCompanyIdentificationNumber(String id) {
		// TODO Auto-generated method stub
		this.identificationNumber = id;
	}

	public void setCompanyName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	public String getCompanyName(){
		return this.name;
	}
	
	public String getCompanyIdentificationNumber(){
		return this.identificationNumber;
	}
	
	public Telephone getCompanyTelephone(){
		return this.telephone;
	}
	
	public Address getCompanyAddress(){
		return this.address;
	}
	
	public Integer getCompanyId(){
		return this.companyId;
	}
	
	
	
	
}
