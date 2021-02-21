/**
 * This class represents a class which shows on
 * item ordered from a menu
 * @author Sarah Storla
 *
 */
public class MenuItem {
	//instance variables
	private String name;
	private double price;
	private int quantity;
	
	//constructor 
	/** 
	 * @param name name of the menu item
	 * @param price price of the menu item
	 * @param quantity quantity of the menu item
	 */
	public MenuItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	//getters and setters for Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//getter and setters for Price
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	//getter and setters for Quantity
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//toString method
	/** Convert the instance variables into formatted String
	 * @return Formatted properties of MenuItem
	 */
	@Override
	public String toString() {
		double total = price*quantity;
		String priceFormat = String.format("%.2f", price);
		String totalFormat = String.format("%.2f", total);
		String str1 = name + "\t";
		String str2 = "\t\t" + "$" + priceFormat + "\t\t";
		String str3 = quantity + "\t";
		String str4 = "\t" + "$" +  totalFormat;
		return(str1 + str2 + str3 + str4 + "\n");
	}
	
	@Override
	//equals method
	/** Compares the equality of two item names - case insensitive
	 * @param n Object of type MenuItem
	 * @return TRUE if items have the same name - case insensitive
	 * 		   FALSE if items do not have the same name - case insensitive
	 */
	public boolean equals(Object n) {
		MenuItem otherName = (MenuItem) n;
		if (this.name.equalsIgnoreCase(otherName.name)) {
			return true;
		}
		return false;
	}
}

