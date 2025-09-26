package PD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The monetary amount the item is being sold for
 */
public class Price implements Comparable<Price>{

	/**
	 * Item associated with the price
	 */
	private Item item;
	/**
	 * The price
	 */
	private BigDecimal price;
	/**
	 * The date the price is effective
	 */
	private LocalDate effectiveDate;

	/**
	 * Constructor
	 */
	public Price() {
		this.item = new Item();
		this.price = new BigDecimal(0);
		this.price.setScale(2, RoundingMode.HALF_UP);
		this.effectiveDate = LocalDate.of(1, 1, 1);
		
	}

	/**
	 * Constructor
	 * @param price of an item
	 * @param effectiveDate of the price
	 * @param endDate of the effective date
	 */
	public Price(String price, String effectiveDate) {
		this.item = new Item();
		this.price = new BigDecimal(price);
		this.price.setScale(2, RoundingMode.HALF_UP);
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy"));
		
		//Previous function date formatter before I knew DateTimerFormatter existed
		/*String[] token = effectiveDate.split("/");
		int[] i = new int[3];
		for(int k = 0; k < i.length; k++) {
			i[k] = Integer.parseInt(token[k]);
		}
		this.effectiveDate = LocalDate.of(i[2], i[0], i[1]);*/
		
	}

	/**
	 * Checks if the price is effective
	 * @param date the price becomes effective
	 */
	public Boolean isEffective(LocalDate date) {
		if(date.isAfter(this.effectiveDate))
			return true;
		else
			return false;
	}

	/**
	 * Calculates the total based on the quantity
	 * @param quantity
	 * @return The total based off of the quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		return BigDecimal.valueOf(quantity).multiply(price);
	}

	/**
	 * Compares to another price
	 * @param price
	 * @return compares the effective dates of two prices
	 */
	public int compareTo(Price price) {
		if (this.effectiveDate.isBefore(price.getEffectiveDate()))
			return -1;
		else if (this.effectiveDate.isAfter(price.getEffectiveDate()))
			return 1;
		else
			return 0;
	}

	public Boolean isPromo() {
		return false;
	}
	
	/**
	 * Converts to a string
	 */
	public String toString() {
		
		return price.toString() + " " + this.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy"));
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = new BigDecimal(price);
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return this.item;
	}

}