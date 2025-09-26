package PD;

import java.util.*;

/**
 * During a session the register is used to scan items for the sale
 */
public class Register {

	/**
	 * The session for the register
	 */
	private ArrayList<Session> session = new ArrayList<Session>();
	/**
	 * The cash drawer for the register
	 */
	private CashDrawer cashDrawer;
	/**
	 * The number for the register
	 */
	private String number;


	public ArrayList<Session> getSession() {
		return this.session;
	}

	
	/**
	 * The constructor
	 */
	public Register() {
		number = "";
		cashDrawer = new CashDrawer();
	}

	/**
	 * The constructor
	 * @param number
	 */
	public Register(String number) {
		this.number = number;
		cashDrawer = new CashDrawer();
	}
	
	/**
	 * Checks if register is used in a session
	 * @return If used
	 * */
	public boolean isUsed() {
		if(session.isEmpty())
			return false;
		else
			return true;
	}

	/**
	 * Converts to a string
	 * @return register number
	 */
	public String toString() {
		return number;
	}
	
	public void setSession(ArrayList<Session> session) {
		this.session = session;
	}

	public CashDrawer getCashDrawer() {
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

	public String getNumber() {
		return this.number;
	}
	
	public void addSession(Session session) {
		this.session.add(session);
	}

	public void setNumber(Store store, String number) {
		store.deleteRegister(this);
		this.number = number;
		store.addRegister(this);
	}


}