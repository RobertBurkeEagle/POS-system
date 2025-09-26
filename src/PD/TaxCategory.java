package PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * The tax categories for items sold
 */
public class TaxCategory {

	/**
	 * The tax rates for the category
	 */
	private TreeSet<TaxRate> taxRates = new TreeSet<TaxRate>();
	/**
	 * The items for the category
	 */
	private TreeMap<String, Item> items = new TreeMap<String, Item>();
	/**
	 * The category name for the tax
	 */
	private String category;

	/**
	 * The constructor for TaxCategory
	 */
	public TaxCategory() {
		this.category = "";
		
	}

	/**
	 * The constructor for TaxCategory
	 * @param category being created
	 */
	public TaxCategory(String category) {
		this.category = category;
		
	}

	/**
	 * Gets the tax rate for a certain date
	 * @param date - Checking what rates are effective on that day
	 * @return The tax rate for date passed in. Null if none found
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		for(TaxRate tr : taxRates) {
			if(tr.isEffective(date))
				return tr.getTaxRate();
		}
		return null;
	}
	
	/**
	 * Adds item to the category
	 * @param item being added to the category
	 * @param key of the item being added to the category
	 */
	public void addItem(String key, Item item) {
		items.put(key, item);
		
	}

	/**
	 * Deletes item from the store
	 * @param key of item being deleted
	 */
	public void deleteItem(String key) {
		items.remove(key);
		
	}

	/**
	 * Adds a tax rate
	 * @param taxRate for a category
	 */
	public void addTaxRate(TaxRate taxRate) {
		taxRates.add(taxRate);
		
	}

	/**
	 * Removes a tax rate
	 * @param taxRate for a category
	 */
	public void removeTaxRate(TaxRate taxRate) {
		taxRates.remove(taxRate);
		
	}

	/**
	 * Checks if the taxCategory is being used
	 */
	public Boolean isUsed() {
		if (items.isEmpty() == true)
			return false;
		else
			return true;
	}
	
	
	/**
	 * Converts to a string
	 * @return Name and tax rate
	 */
	public String toString() {
		return category + " " + this.getTaxRateForDate(LocalDate.now());
	}
	

	public TreeSet<TaxRate> getTaxRates() {
		return this.taxRates;
	}

	public void setTaxRates(TreeSet<TaxRate> taxRates) {
		this.taxRates = taxRates;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


}