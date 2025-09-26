package PD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;

/**
 * The session is where the cashier checks out the items for the customer
 */
public class Session {

	private Cashier cashier;
	/**
	 * The register for the session
	 */
	private Register register;
	/**
	 * The sales for that session
	 */
	private ArrayList<Sale> sales = new ArrayList<Sale>();
	/**
	 * The start time for the session
	 */
	private LocalDateTime startDateTime;
	/**
	 * The end time for the session
	 */
	private LocalDateTime endDateTime;
	/**
	 * The store that owns session
	 * */
	private Store store;
	/**
	 * Starting cash for the session
	 * */
	private BigDecimal startingCash;
	/**
	 * The cash count difference for the session
	 * */
	private BigDecimal diff;
	
	
	/**
	 * The constructor
	 */
	public Session() {
		this.cashier = new Cashier();
		this.register = new Register();
		this.startDateTime = LocalDateTime.now();
		store = null;
		startingCash = null;
		diff = null;
	}

	/**
	 * The constructor
	 * @param cashier starting the session
	 * @param register being used for the session
	 */
	public Session(Store store, Cashier cashier, Register register) {
		this.cashier = cashier;
		cashier.addSession(this);
		this.register = register;
		register.addSession(this);
		this.startDateTime = LocalDateTime.now();
		this.store = store;
		diff = new BigDecimal(0);
	}

	/**
	 * Adds a sale to the session
	 * @param sale being added to the session
	 */
	public void addSale(Sale sale) {
		sales.add(sale);
		
	}

	/**
	 * Removes a sale from the session
	 * @param sale in the session
	 */
	public void removeSale(Sale sale) {
		sales.remove(sale);
		
	}

	/**
	 * Calculates the difference of the beginning cash vs the count at end of the session
	 * @param cash - The beginning amount of cash
	 * @return Result based off of the calculation
	 */
	public BigDecimal calcCashCountDiff(String cash) {
		this.diff = new BigDecimal(Double.valueOf(cash));
		diff = diff.subtract(this.register.getCashDrawer().getCash());
		return diff.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the total money of that session
	 * @return Result based off of calculation
	 */
	public BigDecimal calcTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Sale s : sales) {
			total = total.add(s.calcTotal());
		}
		return total;
	}
	
	public ArrayList<SaleLineItem> getSLIsSold() {
		ArrayList<SaleLineItem> sliArr = new ArrayList<SaleLineItem>();
		Boolean add;
		for (Sale s : sales) {
			for (SaleLineItem sli : s.getSaleLineItems()) {
				add = true;
				for (SaleLineItem sli2 : sliArr) {
					if (sli2.getItem().getNumber() == sli.getItem().getNumber()) {
						sli2.addQuantity(sli.getQuantity());
						add = false;
					}
				}
				if(add == true)
					sliArr.add(sli);
			}
		}
		return sliArr;
	}
	
	/**
	 * Converts to a string
	 * @return Register and cashier total
	 */
	public String toString() {
		String toString = "Session: Cashier: " + this.cashier.toString() + " Register: " 
				+ this.register.toString() + " Total: " + calcTotal().toString() + "\n";
		for (Sale s : sales) {
			toString += s.toString() + "\n";
		}
		
		return toString;

	}

	public Register getRegister() {
		return this.register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}

	public void setStartCash(BigDecimal startCash) {
		startingCash = startCash;
		getRegister().getCashDrawer().setCash(startCash);
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public BigDecimal getStartingCash() {
		return startingCash;
	}

	public void setStartingCash(BigDecimal startingCash) {
		this.startingCash = startingCash;
	}

	public BigDecimal getDiff() {
		return diff;
	}

	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}

}