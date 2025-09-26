package PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PromoPrice extends Price {

	/**
	 * The end date for the promotion
	 */
	private LocalDate endDate;

	/**
	 * Constructor
	 */

	
	public PromoPrice() {
		super();
		this.endDate = LocalDate.of(1, 1, 1);
	}
	
	/**
	 * Constructor
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String price, String effectiveDate, String endDate) {
		super(price, effectiveDate);
		this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yy"));
		
		/*String[] token = endDate.split("/");
		int[] i = new int[3];
		for(int k = 0; k < i.length; k++) {
			i[k] = Integer.parseInt(token[k]);
		}
		this.endDate = LocalDate.of(i[2], i[0], i[1]);*/
		
	}

	/**
	 * Checks if the promo is effective
	 * @param date
	 * @return True if effective. False if not effective
	 */
	public Boolean isEffective(LocalDate date) {
		if(date.isAfter(super.getEffectiveDate()) && date.isBefore(endDate))
			return true;
		else
			return false;
	}
	
	public Boolean isPromo() {
		return true;
	}

	/**
	 * Converts to string
	 * @return End date and price for promo
	 */
	public String toString() {
		return super.toString() + " - " + endDate.format(DateTimeFormatter.ofPattern("M/d/yy"));
	}
	
	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}