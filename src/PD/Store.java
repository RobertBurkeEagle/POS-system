package PD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

import DM.StoreDM;

/**
 * The container that every object and action happens in
 */
public class Store {

	/**
	 * Number for the store
	 */
	private String number;
	/**
	 * The name for the store
	 */
	private String name;
	/**
	 * The cashiers for the store
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * The sessions for the store
	 */
	private ArrayList<Session> sessions;
	/**
	 * The registers for the store
	 */
	private TreeMap<String, Register> registers;
	/**
	 * The tax categories for the store
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * The upcs for the store
	 */
	private TreeMap<String, UPC> upcs;
	/**
	 * The items in the store
	 */
	private TreeMap<String, Item> items;

	/**
	 * Constructor for the store
	 */
	public Store() {
		this.name = "";
		this.number = "";
		items = new TreeMap<String, Item>();
		upcs = new TreeMap<String, UPC>();
		taxCategories = new TreeMap<String, TaxCategory>();
		registers = new TreeMap<String, Register>();
		sessions = new ArrayList<Session>();
		cashiers = new TreeMap<String, Cashier>();
		
	}

	/**
	 * Constructor for the store
	 * @param number assigned to the store
	 * @param name assigned to the store
	 */
	public Store(String name, String number) {
		this.name = name;
		this.number = number;
		items = new TreeMap<String, Item>();
		upcs = new TreeMap<String, UPC>();
		taxCategories = new TreeMap<String, TaxCategory>();
		registers = new TreeMap<String, Register>();
		sessions = new ArrayList<Session>();
		cashiers = new TreeMap<String, Cashier>();
	}
	
	public void loadStore() {
		StoreDM.loadStore(this);
	}

	/**
	 * Adds item to the store
	 * @param item being added to the store
	 * @param key of the item being added to the store
	 */
	public void addItem(Item item) {
		items.put(item.getNumber(), item);
		
	}

	/**
	 * Deletes item from the store
	 * @param key of item being deleted
	 */
	public void deleteItem(Item item) {
		item.unloadItem(this);
		items.remove(item.getNumber());
	}

	/**
	 * Adds UPC to the store
	 * @param upc being added to the store
	 * @param key of the UPC
	 */
	public void addUPC(UPC upc) {
		upcs.put(upc.getUpc(), upc);
		
	}

	/**
	 * Deletes UPC from the store
	 * @param key of UPC
	 */
	public void deleteUPC(UPC upc) {
		upcs.remove(upc.getUpc());
		
	}

	/**
	 * Adds a register to the store
	 * @param register being added to the store
	 * @param key of the Register being added
	 */
	
	
	public void addRegister(Register register) {
		registers.put(register.getNumber(), register);
		
	}

	/**
	 * Deletes a register from the store
	 * @param key for the register
	 */
	public void deleteRegister(Register register) {
		registers.remove(register.getNumber());
	}

	/**
	 * Adds a cashier to the store
	 * @param cashier adding to store
	 * @param key for the cashier
	 */
	public void addCashier(Cashier cashier) {
		cashiers.put(cashier.getNumber(), cashier);
		
	}

	/**
	 * Deletes cashier from the store
	 * @param key for cashier
	 */
	public void deleteCashier(Cashier cashier) {
		cashiers.remove(cashier.getNumber());
	}

	/**
	 * Adds a tax category to the store
	 * @param taxCategory being added to store
	 * @param key
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		taxCategories.put(taxCategory.getCategory(), taxCategory);
		
	}

	/**
	 * Deletes a tax category from the store
	 * @param key for tax category
	 */
	public void deleteTaxCategory(TaxCategory tc) {
		taxCategories.remove(tc.getCategory());
		
	}

	/**
	 * Adds a session to the store
	 * @param session being added to the store
	 */
	public void addSession(Session session) {
		sessions.add(session);
		
	}

	/**
	 * Deletes a session from the store
	 * @param session being deleted from store
	 */
	public void deleteSession(Session session) {
		sessions.remove(session);
		
	}

	/**
	 * Finds a register by the number
	 * @param number
	 * @return Register for the ID number. Null if not found
	 */
	public Register findRegisterByNumber(String number) {
		return registers.get(number);
	}

	/**
	 * Finds an item by the UPC
	 * @param upc for the item
	 * @return Item for the UPC. Null if not found
	 */
	public Item findItemByUPC(String upc) {
		if(upcs.containsKey(upc)) 
			return upcs.get(upc).getItem();
		else 
			return null;
	}

	/**
	 * Finds the item by its number
	 * @param number
	 * @return Item for the number passed in. Null if not found
	 */
	public Item findItemByNumber(String number) {
		return items.get(number);
	}

	/**
	 * Finds a cashier by their number
	 * @param number
	 * @return Cashier for the number passed. Null if not found
	 */
	public Cashier findCashierByNumber(String number) {
		return cashiers.get(number);
	}

	/**
	 * Finds a tax category by its name
	 * @param category - Name of the category
	 * @return Tax category for the category passed. Null if not found
	 */
	public TaxCategory findTaxCategoryByName(String category) {
		return taxCategories.get(category);
	}

	/**
	 * Gets the sessions for the given date
	 * @return ArrayList of sessions on that date
	 */
	public ArrayList<Session> getSessionsForDate(LocalDate date) {
		ArrayList<Session> sessionsForDate = new ArrayList<Session>();
		for (Session s : sessions) {
			if (date.equals(s.getStartDateTime().toLocalDate()))
				sessionsForDate.add(s);
		}
		return sessionsForDate;
	}
	
	public ArrayList<SaleLineItem> getSLIsForDate(LocalDate date) { 
		ArrayList<SaleLineItem> sliArrFinal = new ArrayList<SaleLineItem>();
		ArrayList<SaleLineItem> sliArrTemp = new ArrayList<SaleLineItem>();
		Boolean add;
		for (Session s : this.getSessionsForDate(date)) {
			sliArrTemp.clear();
			sliArrTemp.addAll(s.getSLIsSold());
			for(SaleLineItem sli : sliArrTemp) {
				add = true;
				for (SaleLineItem sli2 : sliArrFinal) {
					if (sli2.getItem().getNumber() == sli.getItem().getNumber()) {
						sli2.addQuantity(sli.getQuantity());
						add = false;
					}
				}
				if(add == true)
					sliArrFinal.add(sli);
			}
		}
		
		return sliArrFinal;
	}
	
	/**
	 * Converts to a string
	 * @return Information about the store
	 */
	public String toString() {
		return "Store name: " + this.name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<String, Cashier> getCashiers() {
		return cashiers;
	}

	public void setCashiers(TreeMap<String, Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public TreeMap<String, TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	public void setTaxCategories(TreeMap<String, TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}

	public TreeMap<String, UPC> getUpcs() {
		return upcs;
	}

	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}

	public TreeMap<String, Item> getItems() {
		return items;
	}

	public void setItems(TreeMap<String, Item> items) {
		this.items = items;
	}

	public void setRegisters(TreeMap<String, Register> registers) {
		this.registers = registers;
	}
	
	public TreeMap<String, Register> getRegisters() {
		return registers;
		
	}

	
	
	
	
	
	
	

}