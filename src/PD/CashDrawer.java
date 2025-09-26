package PD;

import java.math.BigDecimal;

/**
 * Holds the money value of the given register.
 */
public class CashDrawer {

	/**
	 * The amount of cash stored
	 */
	private BigDecimal cashAmount;
	/**
	 * The position its in
	 */
	private int position;

	/**
	 * Constructor
	 */
	public CashDrawer() {
		this.cashAmount = new BigDecimal(0);
		this.position = 0;
		
	}

	/**
	 * Removes cash from the drawer
	 * @param cash - amount of cash being removed
	 */
	public void removeCash(BigDecimal cash) {
		cashAmount.subtract(cash);
		
	}

	/**
	 * Adds cash to the drawer
	 * @param cash - amount of cash being added
	 */
	public void addCash(BigDecimal cash) {
		cashAmount = cashAmount.add(cash);
		
	}

	/**
	 * Converts to string
	 * @return Amount of money and position
	 */
	public String toString() {
		String toString = String.valueOf(this.cashAmount) + this.position;
		return toString;
	}
	
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public BigDecimal getCash() {
		return cashAmount;
	}
	
	public void setCash(BigDecimal cash) {
		this.cashAmount = cash;
	}

}