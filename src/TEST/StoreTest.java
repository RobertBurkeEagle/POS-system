package TEST;

import java.math.BigDecimal;
import java.time.LocalDate;

import PD.Cash;
import PD.CashDrawer;
import PD.Cashier;
import PD.Store;
import PD.Item;
import PD.Person;
import PD.Price;
import PD.Register;
import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.TaxCategory;
import PD.TaxRate;
import PD.UPC;

public class StoreTest {

	public static void main(String[] args) {
		/*String bar = "===============\n";
		
		//AC #1
		Store store = new Store("NewStore", "1");
		
		TaxRate salesTax = new TaxRate("01/01/2024", "0.01");
		
		TaxCategory fruit = new TaxCategory("fruit");
		TaxCategory furniture = new TaxCategory("furniture");
		TaxCategory tech = new TaxCategory("tech");
		fruit.addTaxRate(salesTax);
		furniture.addTaxRate(salesTax);
		tech.addTaxRate(salesTax);
		
		Item apple = new Item("1001", "Red Apple");
		apple.addPrice(new Price("4.32", "10/02/1994"));
		apple.setTaxCategory(fruit);
		apple.addUPC(new UPC("1020304050"));
		
		Item table = new Item("1023", "Wooden Table");
		table.addPrice(new Price("122.54", "06/22/2004"));
		table.setTaxCategory(furniture);
		table.addUPC(new UPC("55555"));
		
		Item laptop = new Item("1047", "Asus Laptop");
		laptop.addPrice(new Price("2003.88", "12/08/2023"));
		laptop.setTaxCategory(tech);
		laptop.addUPC(new UPC("4532"));
		
		store.addItem(apple);
		store.addItem(table);
		store.addItem(laptop);
		
		System.out.println(store.toString());
		System.out.print(bar + "Items\n" + bar);
		System.out.println(store.findItemByNumber(apple.getNumber()).toString());
		System.out.println(store.findItemByNumber(table.getNumber()).toString());
		System.out.println(store.findItemByNumber(laptop.getNumber()).toString());
		
		
		//AC #2
		store.addCashier(new Cashier("1", new Person("John", "123 myStreet", "Edmond", "OK", "73013", "405-222-222", "5554444333"), "pass"));
		store.addCashier(new Cashier("2", new Person("Dave", "123 myStreet", "Edmond", "OK", "73013", "405-222-232", "5333355553"), "word"));
		store.addCashier(new Cashier("3", new Person("Bill", "123 myStreet", "Edmond", "OK", "73013", "405-222-225", "9593872772"), "passWord"));
		
		
		
		System.out.print(bar + "Cashiers\n" + bar);
		System.out.println(store.findCashierByNumber("1").toString());
		System.out.println(store.findCashierByNumber("2").toString());
		System.out.println(store.findCashierByNumber("3").toString());
		
		//AC #3
		
		store.addRegister(new Register("1"));
		store.findRegisterByNumber("1").setCashDrawer(new CashDrawer());
		store.addRegister(new Register("2"));
		store.findRegisterByNumber("2").setCashDrawer(new CashDrawer());
		
		System.out.print(bar + "Registers\n" + bar);
		System.out.println(store.findRegisterByNumber("1").toString());
		System.out.println(store.findRegisterByNumber("2").toString());
		
		//AC #4
		
		Session session = new Session(store.findCashierByNumber("1"), store.findRegisterByNumber("1"));
		
		Sale s = new Sale("false");
		s.addSaleLineItem(new SaleLineItem(s, apple, "2"));
		s.addSaleLineItem(new SaleLineItem(s, table, "1"));
		session.addSale(s);
		
		System.out.print(bar + "Session\n" + bar);
		System.out.println(session.toString());*/
	}

}
