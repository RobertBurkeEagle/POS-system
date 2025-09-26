package PD;

import java.math.BigDecimal;

/**
 * Customers cash
 */
public class Cash extends Payment {

	/**
	 * Constructor
	 */
	public Cash() {
		this.setAmount(new BigDecimal(0));
		this.setAmtTendered(new BigDecimal(0));
		
	}

	/**
	 * Constructor
	 * @param amount needed
	 * @param Amount tendered by customer
	 */
	public Cash(String amount, String amtTendered) {
		this.setAmount(BigDecimal.valueOf(Double.parseDouble(amount)));
		this.setAmtTendered(BigDecimal.valueOf(Double.parseDouble(amtTendered)));
		
	}

	/**
	 * If the form of payment counts as cash
	 * @return True if counts as cash. False if does not count as cash
	 */
	public Boolean countsAsCash() {
		return true;
	}

	/**
	 * Converts to string
	 * @return The amount of cash
	 */
	public String toString() {
		String toString = String.valueOf(getAmount());
		return toString;
	}

}