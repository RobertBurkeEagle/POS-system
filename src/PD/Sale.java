package PD;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Sale {

	/**
	 * The sale line items for the sale
	 */
	private ArrayList<SaleLineItem> saleLineItems = new ArrayList<SaleLineItem>();
	/**
	 * The payments for the sale
	 */
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	/**
	 * The date and time for the sale
	 */
	private LocalDateTime dateTime;
	/**
	 * If the sale is tax free or not
	 */
	private Boolean taxFree;

	/**
	 * Constructor
	 */
	public Sale() {
		dateTime = LocalDateTime.now();
		taxFree = false;
		
	}

	/**
	 * Constructor
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		if(taxFree.equals("Y"))
			this.taxFree = true;
		else
			this.taxFree = false;
		
		dateTime = LocalDateTime.now();
	}

	/**
	 * Adds a payment to the sale
	 * @param payment from the customer
	 */
	public void addPayment(Payment payment) {
		payments.add(payment);
		
	}

	/**
	 * Removes a payment from the sale
	 * @param payment in the sale
	 */
	public void removePayment(Payment payment) {
		payments.remove(payment);
		
	}

	/**
	 * Adds a sale item
	 * @param Sale line item
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		saleLineItems.add(sli);
		
	}

	/**
	 * Removes a sale item
	 * @param Sale line item in the sale
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		saleLineItems.remove(sli);
		
	}

	/**
	 * Calculates the total cost for the sale
	 * @return Result of the calculation
	 */
	public BigDecimal calcTotal() {
		return this.calcSubTotal().add(this.calcTax());
	}

	/**
	 * Calculates the sub total for the entire sale
	 * @return The subtotal based on calculation
	 */
	public BigDecimal calcSubTotal() {
		BigDecimal st = new BigDecimal(0);
		for (SaleLineItem sli : saleLineItems) {
			st = st.add(sli.calcSubTotal());
		}
		return st;
	}

	/**
	 * Calculates the tax for the sale
	 * @return The total for the tax of the sale based off of calculation
	 */
	public BigDecimal calcTax() {
		BigDecimal tax = new BigDecimal(0);
		if (taxFree == true)
			return new BigDecimal(0);
		else
			for (SaleLineItem sli : saleLineItems) {
				tax = tax.add(sli.calcTax());
			}
		return tax;
			
	}

	/**
	 * Gets the total payments for the sale
	 * @return The total payments for the sale
	 */
	public BigDecimal getTotalPayments() {
		BigDecimal tp = new BigDecimal(0);
		for (Payment pmnt : payments) {
			tp = tp.add(pmnt.getAmount());
		}
		return tp;
	}

	/**
	 * Checks if the payment is enough
	 * @return True if the payment is enough. False if payment is not enough
	 */
	public boolean isPaymentEnough() {
		if (new BigDecimal(0).compareTo(this.calcAmountForPayment()) > -1)
			return true;
		else
			return false;
	}
	/**
	 * Calculates the amount for the payment
	 * @param amtTendered
	 * @return The amount for the payment
	 */
	public BigDecimal calcAmountForPayment() {
		return calcTotal().subtract(calcAmtTendered());
	}

	/**
	 * Calculates the change
	 * @return The remaining change for the payment
	 */
	public BigDecimal calcChange() {
		return this.calcAmtTendered().subtract(this.calcTotal());
	}

	/**
	 * Calculates the amount tendered
	 * @return The amount tendered
	 */
	public BigDecimal calcAmtTendered() {
		BigDecimal tat = new BigDecimal(0);
		for (Payment pmnt : payments) {
			tat = tat.add(pmnt.getAmount());
		}
		return tat;
	}
	
	/**
	 * Finds a saleLineItem for the given item
	 * @return The amount tendered
	 */
	
	public SaleLineItem getSLIForItem(Item item) {
		for(SaleLineItem s : this.saleLineItems) {
			if(s.getItem().equals(item))
				return s;
		}
		return null;
	}

	/**
	 * Converts to string
	 * @return Date and time, if it was tax free, payments
	 */
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy H:mm");
		
		String toString = "Transaction Time: " + dateTime.format(formatter) + "\nSale: Subtotal = " + calcSubTotal().toString() 
				+ " Tax = " + calcTax().toString() + " Total = " + calcTotal().toString() + " Payment: " + calcAmtTendered() + " Change: " + calcChange()+ "\n" ;
		
		for(SaleLineItem sli : saleLineItems) {
			toString += (sli.toString()) + "\n";
		}
		return toString;
	}
	
	public Boolean getTaxFree() {
		return this.taxFree;
	}

	public void setTaxFree(Boolean taxFree) {
		this.taxFree = taxFree;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}