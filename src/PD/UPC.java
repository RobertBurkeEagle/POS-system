package PD;

/**
 * The universal product code for each item
 */
public class UPC {

	/**
	 * The item associated with the UPC
	 */
	private Item item;
	/**
	 * The UPC itself
	 */
	private String upc;
	
	/**
	 * Constructor
	 */
	public UPC() {
		this.upc = "";
		
	}

	/**
	 * Constructor
	 * @param upc being constructed
	 */
	public UPC(Item item, Store store, String upc) {
		this.upc = upc;
		store.addUPC(this);
		this.item = item;
	}

	/**
	 * Converts to string
	 * @return UPC
	 */
	public String toString() {
		return "UPC: " + this.upc;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}


}