package PD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * The current item going to the sale
 */
public class SaleLineItem {

	/**
	 * The item on the sale line
	 */
	private Item item;
	/**
	 * The sale for the item
	 */
	private Sale sale;
	/**
	 * The quantity of items
	 */
	private int quantity;

	
	/**
	 * Constructor
	 */
	public SaleLineItem() {
		this.item = new Item();
		this.sale = new Sale();
		this.quantity = 0;
		
	}

	/**
	 * Constructor
	 * @param sale of the item being sold
	 * @param item being sold
	 * @param quantity of the item being sold
	 */
	public SaleLineItem(Sale sale, Item item, String quantity) {
		this.item = item;
		this.sale = sale;
		this.quantity = Integer.parseInt(quantity);
		
	}

	/**
	 * Calculates the sub total for the items
	 */
	public BigDecimal calcSubTotal() {
		return this.item.calcAmountForDateQty(LocalDate.now(), this.quantity).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the tax for the items
	 */
	public BigDecimal calcTax() {
		return this.item.getTaxRateForDate(LocalDate.now()).multiply(new BigDecimal(this.quantity).multiply(item.getPriceForDate(LocalDate.now()).getPrice())).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Converts to a string
	 */
	public String toString() {
		return item.getNumber() + " " + item.getDescription() + " " + this.getQuantity() + " " + calcSubTotal().toString() + " " + calcTax().toString();
	}
	
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}