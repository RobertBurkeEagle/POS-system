package PD;

/**
 * Hold all the information for a person
 */
public class Person {

	/**
	 * Cashier for the person
	 */
	private Cashier cashier;
	/**
	 * The name for the person
	 */
	private String name;
	/**
	 * The street address for the person
	 */
	private String address;
	/**
	 * The city of the person
	 */
	private String city;
	/**
	 * The geographical state of the person
	 */
	private String state;
	/**
	 * The zip code for the person
	 */
	private String zip;
	/**
	 * The social security number for the person
	 */
	private String ssn;
	/**
	 * The Phone number for the person
	 */
	private String phone;

	/**
	 * The constructor
	 */
	public Person() {
		this.name = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.ssn = "";
		this.phone = "";
		
	}

	/**
	 * The constructor
	 * @param name - name of the person
	 * @param address - address of the person
	 * @param city - city of the person
	 * @param state - state of the person
	 * @param zip - zip of the person
	 * @param ssn - ssn of the person
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String ssn) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.phone = phone;
		
	}

	/**
	 * Converts to a string
	 * @return Name and address for person
	 */
	public String toString() {
		return name + " " + address;
	}
	
	public Cashier getCashier() {
		return this.cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}