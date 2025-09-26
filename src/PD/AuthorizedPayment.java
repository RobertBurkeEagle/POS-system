package PD;

import java.util.Random;

/**
 * Checks if the payment is authorized
 */
public class AuthorizedPayment extends Payment {

	/**
	 * The code for authorization
	 */
	private String authorizationCode;

	public String getAuthorizationCode() {
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	/**
	 * Checks if the payment is authorized (Currently random)
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
	 * Checks if the payment counts as cash
	 * @return True if counts as cash. False if does not count as cash
	 */
	public Boolean countsAsCash() {
		return false;
	}

}