package PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * The customers credit card
 */
public class Credit extends AuthorizedPayment {

	/**
	 * The type of card being used
	 */
	private String cardType;
	/**
	 * The card number
	 */
	private String cardNumber;
	/**
	 * The expiration date
	 */
	private LocalDate expireDate;


	/**
	 * Constructor
	 */
	public Credit() {
		this.cardType = "";
		this.cardNumber = "";
		this.expireDate = LocalDate.now();
		this.setAmount(new BigDecimal(0));
	}

	/**
	 * Constructor
	 * @param amount - The value being charged on card
	 * @param cardType - The type of card being used (ex. Mastercard, BOFA)
	 * @param cardNumber - The bank number associated with the card
	 * @param expireDate - The expiration date of the card
	 */
	public Credit(String amount, String cardType, String cardNumber, String expireDate) {
		this.setAmount(new BigDecimal(amount));
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expireDate = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
	 * @return Card number, card type, and expiration date
	 */
	public String toString() {
		return cardNumber + " " + expireDate + " " + cardType;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAcctNumber() {
		return this.cardNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.cardNumber = acctNumber;
	}

	public LocalDate getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		
		this.expireDate = expireDate;
	}

}