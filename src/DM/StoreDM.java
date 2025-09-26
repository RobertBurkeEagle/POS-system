package DM;

import java.io.*;

import PD.*;

public class StoreDM {

	public static void loadStore(Store store) {
		
		String fileName = new String("src/StoreData_v2024FA.csv");
		String line = null;
		String[] token;
		String objectType;
		
		try {
			FileReader reader = new FileReader(fileName);
			
			BufferedReader buffRead = new BufferedReader(reader);
			
			while((line = buffRead.readLine()) != null) {
				
				token = line.split(",");
				objectType = token[0];
				
				if(objectType.equals("Store")) {
					store.setName(token[1]);
				}
				else if (objectType.equals("TaxCategory")) {
					store.addTaxCategory(new TaxCategory(token[1]));
					store.findTaxCategoryByName(token[1]).addTaxRate(new TaxRate(token[3], token[2]));
				}
				else if (objectType.equals("Cashier")) {
					store.addCashier(new Cashier(token[1], new Person(token[2], token[4], token[5], token[6], token[7], token[8], token[3]), token[9]));
				}
				else if (objectType.equals("Item")) {
					store.addItem(new Item(token[1], token[3]));
					store.findItemByNumber(token[1]).setTaxCategory(store.findTaxCategoryByName(token[4]));
					store.findItemByNumber(token[1]).addPrice(new Price(token[5], token[6]));
					store.findItemByNumber(token[1]).addUPC(new UPC(store.findItemByNumber(token[1]), store, token[2]));
					if (token.length > 7) {
						store.findItemByNumber(token[1]).addPrice(new PromoPrice(token[7], token[8], token[9]));
					}
					
				}
				else if (objectType.equals("Register")) {
					store.addRegister(new Register(token[1]));
				}
				else if (objectType.equals("Session")) {
					store.addSession(new Session(store, store.findCashierByNumber(token[1]), store.findRegisterByNumber(token[1])));
				}
				else if (objectType.equals("Sale")) {
					store.getSessions().getLast().addSale(new Sale(token[1]));
				}
				else if (objectType.equals("SaleLineItem")) {
					store.getSessions().getLast().getSales().getLast().addSaleLineItem(new SaleLineItem(store.getSessions().getLast().getSales().getLast(), store.findItemByNumber(token[1]), token[2]));
				}
				else if (objectType.equals("Payment")) {
					if (token[1].equals("Cash")) {
						store.getSessions().getLast().getSales().getLast().addPayment(new Cash(token[3], token[2]));
					}
					else if (token[1].equals("Credit")) {
						store.getSessions().getLast().getSales().getLast().addPayment(new Credit(token[2], token[4], token[5], token[6]));
					}
					else if (token[1].equals("Check")) {
						store.getSessions().getLast().getSales().getLast().addPayment(new Check(token[2], token[3], token[4], token[5]));
					}
					
				}
				
			}
			buffRead.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found... " + fileName);
		}
		catch(IOException e) {
			System.out.println("Error reading file... " + fileName);
		}
		
		
	}
}
