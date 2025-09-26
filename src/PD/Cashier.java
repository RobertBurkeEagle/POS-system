package PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * The object that joins a session to run the register
 */
public class Cashier {

	/**
	 * The person of the cashier
	 */
	private Person person;
	/**
	 * The sessions the cashier has worked
	 */
	private ArrayList<Session> sessions = new ArrayList<Session>();
	/**
	 * The number for the cashier
	 */
	private String number;
	/**
	 * The password for the cashier
	 */
	private String password;

	/**
	 * The constructor
	 */
	public Cashier() {
		number = ""; 
		person = new Person(); 
		password = "";
		
	}

	/**
	 * The constructor
	 * @param number of the cashier
	 * @param person
	 * @param password for the cashier
	 */
	public Cashier(String number, Person person, String password) {
		this.number = number;
		this.person = person;
		this.password = password;
		
	}

	/**
	 * Adds a session to the cashier
	 * @param session
	 */
	public void addSession(Session session) {
		sessions.add(session);
		
	}

	/**
	 * Deletes a session from the cashier
	 * @param session
	 */
	public void deleteSession(Session session) {
		sessions.remove(session);
		
	}

	/**
	 * Checks if the cashier is authorized
	 * @param password for the cashier
	 * @return True if authorized. False if not
	 */
	public Boolean isAuthorized(String password) {
		if (this.password.equals(password))
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if the cashier is used in a session
	 * @return True if used. False if not
	 */
	public boolean isUsed() {
		
		if(sessions.isEmpty())
			return false;
		else
			return true;
	}
	
	/**
	 * Gets the sessions for the given date
	 * @return ArrayList of sessions on that date
	 */
	public ArrayList<Session> sessionsForDate(LocalDate date) {
		ArrayList<Session> sessionsForDate = new ArrayList<Session>();
		for (Session s : sessions) {
			if (date.equals(s.getStartDateTime().toLocalDate()))
				sessionsForDate.add(s);
		}
		return sessionsForDate;
		
	}
	
	/**
	 * Gets the number of sales for the given date
	 * @return int count of sales on that date
	 */
	public int salesForDate(LocalDate date) {
		int sales = 0;
		for(Session s : sessionsForDate(date)) {
			sales += s.getSales().size();
		}
		return sales;
	}
	
	/**
	 * Gets the total money amount for the given date
	 * @return BigDecimal of amount on that date
	 */
	public BigDecimal TotalForDate(LocalDate date) {
		BigDecimal total = new BigDecimal(0);
		for(Session se : sessionsForDate(date))
			for (Sale s : se.getSales()) {
				total = total.add(s.getTotalPayments());
			}	
		return total;
	}
	
	/**
	 * Gets the cash count diff for the given date
	 * @return BigDecimal of diff for that date
	 */
	public BigDecimal diffForDate(LocalDate date) {
		BigDecimal total = new BigDecimal(0);
		for(Session s : sessionsForDate(date)) {
			total = total.add(s.getDiff());
		}
		return total;
	}

	/**
	 * Converts to a string
	 * @return Name of person and number
	 */
	public String toString() {
		return number + " " + this.person.getName();
	}
	
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(Store store, String number) {
		store.deleteCashier(this);
		this.number = number;
		store.addCashier(this);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}