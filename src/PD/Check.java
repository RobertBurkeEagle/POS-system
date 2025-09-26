package PD;

import java.math.BigDecimal;
import java.util.Random;

/**
 * The customers check
 */
public class Check extends AuthorizedPayment {

	/**
	 * The routing number for the check
	 */
	private String routingNumber;
	/**
	 * The number for the customers check account
	 */
	private String accountNumber;
	/**
	 * The number for the check
	 */
	private String checkNumber;

	/**
	 * Constructor
	 */
	public Check() {
		super();
		this.routingNumber = "";
		this.checkNumber = "";
		this.accountNumber = "";
		this.setAmount(new BigDecimal(0));
	}

	/**
	 * Constructor
	 * @param amount - value of the check
	 * @param accountNumber for the checking account
	 * @param checkNumber
	 * @param routingNumber to the bank
	 */
	public Check(String amount, String accountNumber, String checkNumber, String routingNumber) {
		this.setAmount(BigDecimal.valueOf(Double.parseDouble(amount)));
		this.accountNumber = accountNumber;
		this.checkNumber = checkNumber;
		this.routingNumber = routingNumber;
		
	}

	/**
	 * Checks if authorized (Currently random)
	 * @return True if authorized. False if not authorized
	 */
	public Boolean isAuthorized() {
		Random authGen = new Random();
		int auth = authGen.nextInt(2) + 1;
		if (auth == 1)
			return true;
		else
			return false;
	}

	/**
	 * Converts to string
	 * @return The routing number, account number, and check number.
	 */
	public String toString() {
		return routingNumber + " " + checkNumber + " " + accountNumber;
	}

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


}