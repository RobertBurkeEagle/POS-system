package PD;

import java.math.BigDecimal;

/**
 * The payment the customer is using to purchase the item
 */
public class Payment {

	/**
	 * The payment amount
	 */
	private BigDecimal amount;
	/**
	 * The amount tendered
	 */
	private BigDecimal amtTendered;

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmtTendered() {
		return this.amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered) {
		this.amtTendered = amtTendered;
	}

	/**
	 * If the payment is made in cash
	 * @return True if it counts as cash. False if it does not count as cash
	 */
	public Boolean countsAsCash() {
		return false;
	}

}