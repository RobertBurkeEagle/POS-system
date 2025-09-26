package PD;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.*;

/**
 * What the store holds and sells to the customer
 */
public class Item {

	/**
	 * The tax category for the item
	 */
	private TaxCategory taxCategory;
	/**
	 * The items for the sale line
	 */
	private ArrayList<SaleLineItem> saleLineItems = new ArrayList<SaleLineItem>();
	/**
	 * The prices for the items
	 */
	private TreeSet<Price> prices = new TreeSet<Price>();
	/**
	 * The upcs for the items
	 */
	private TreeMap<String, UPC> upcs = new TreeMap<String, UPC>();
	/**
	 * The number for the item
	 */
	private String number;
	/**
	 * The description for the item
	 */
	private String description;
	

	/**
	 * Constructor
	 */
	public Item() {
		this.taxCategory = new TaxCategory();
		this.number = "null";
		this.description = "null";
		
	}

	/**
	 * Constructor
	 * @param number of the item
	 * @param description of the item
	 */
	public Item(String number, String description) {
		this.number = number;
		this.description = description;
		
	}

	/**
	 * Adds a price to an item
	 * @param price for an item
	 */
	public void addPrice(Price price) {
		prices.add(price);
	}

	/**
	 * Removes a price from an item
	 * @param price of an item
	 */
	public void removePrice(Price price) {
		prices.remove(price);
		
	}

	/**
	 * Adds a UPC to the item
	 * @param upc for an item
	 * @param key
	 */
	public void addUPC(UPC upc) {
		upcs.put(upc.getUpc(), upc);
	}

	/**
	 * Removes a UPC from the item
	 * @param upc for a upc
	 */
	public void removeUPC(UPC upc) {
		upcs.remove(upc.getUpc());
	}
	
	/**
	 * Prepares item to be deleted by removing it from all associated UPCs
	 * */
	
	public void unloadItem(Store store) {
		for(UPC x : upcs.values()) {
			store.deleteUPC(x);
		}
	}
	
	/**
	 * Adds a sale item
	 * @param Sale line item being added to list
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		saleLineItems.add(sli);
	}

	/**
	 * Removes a sale item
	 * @param Sale line item being removed
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		saleLineItems.remove(sli);
	}

	/**
	 * Gets the price for a specific date
	 * @param date
	 * @return The price for the date provided. Null if none found
	 */
	public Price getPriceForDate(LocalDate date) {
		Price price = new Price();
		for (Price e : prices) {
			if(e.isEffective(date))
				price = e;
		}
		return price;
	}

	/**
	 * Gets the tax rate for a specific date
	 * @param date
	 * @return The tax rate for the date provided. Null if none found
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		return taxCategory.getTaxRateForDate(date);
	}

	/**
	 * Calculates the total amount for the date and quantity
	 * @param date
	 * @param quantity
	 * @return The amount based off of the passed date and quantity. Null if none found
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		return this.getPriceForDate(date).getPrice().multiply(new BigDecimal(quantity));
	}


	/**
	 * Converts to string
	 * @return The description, number, price, and taxRate
	 */
	public String toString() {
		if(this.prices.isEmpty() || this.upcs.isEmpty())
			return number + " " + description + " " + taxCategory.getTaxRateForDate(LocalDate.now());
		else
			return number + " " + description + " " + this.getPriceForDate(LocalDate.now()).getPrice() + " " + taxCategory.getTaxRateForDate(LocalDate.now()) + " " + upcs.firstKey();
	}
	
	public TaxCategory getTaxCategory() {
		return this.taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
		taxCategory.addItem(this.number, this);
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	public TreeSet<Price> getPrices() {
		return prices;
	}

	public void setPrices(TreeSet<Price> prices) {
		this.prices = prices;
	}

	public TreeMap<String, UPC> getUpcs() {
		return upcs;
	}

	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}


}