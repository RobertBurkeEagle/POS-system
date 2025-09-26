package UI;

import java.util.Map.Entry;

import javax.swing.JFrame;

import PD.*;

public class POSSTART {

	private static Store store;
	private static String bar = "==============\n";
	
	public static void main(String[] args) {
	
		store = new Store();
		store.loadStore();
		startPOS();
		POSJFRAME.open(store);
		
	}
		public static void startPOS() {
			System.out.println(store.getName());
			System.out.print(bar + "Cashiers\n" + bar);
			for(Entry<String, Cashier> i : store.getCashiers().entrySet()) {
				System.out.println(i.getValue().toString());
			}
			System.out.print(bar + "Registers\n" + bar);
			for(Entry<String, Register> i : store.getRegisters().entrySet()) {
				System.out.println(i.getValue().toString());
			}
			System.out.print(bar + "Items\n" + bar);
			for(Entry<String, Item> i : store.getItems().entrySet()) {
				System.out.println(i.getValue().toString());
			}
			System.out.print(bar + "Sessions\n" + bar);
			for(Session i : store.getSessions()) {
				System.out.println(i.toString());
			}
	}
}
