/**
 * This class represents a class which shows a 
 * collection of MenuItems
 * @author Sarah Storla
 */

public class Order{
	//instance variables
	private String restaurant;  //name of restaurant
	private MenuItem items[];  
	private int numItems; //number of MenuItems added to Order
	private final double taxRate = 0.08;
	private final double percentage = .20;
	
	//No-arg constructor
	public Order() {
		this.items = new MenuItem[25];
		numItems = 0;
	}
	
	//one para. constructor
	/** 
	 * @param retraurant name of the restaurant
	 */
		public Order(String restaurant) {
		this.restaurant = restaurant;
		this.items = new MenuItem[25];
		numItems = 0;
	}
	
	//two para constructor
	//initalCap means initial capacity
		/** 
		 * @param restaurant name of the restaurant
		 * @param initalCap is the initial capacity of MenuItems
		 */
	public Order(String restaurant, int initalCap) {
		this.restaurant = restaurant;
		this.items = new MenuItem[initalCap];
		numItems = 0;
	}
	
	//add method
	/** 
	 * adds a new menuItem, increases the quantity if already added
	 * or sends error message if the array is full
	 * @param name name of the menu item
	 * @param price price of the menu item
	 * @param quantity quantity of the menu item
	 * @return FALSE if the array is full
	 * @return TRUE  if new item added or quantity is increased
	 */
	 public boolean add(String name, double price, int quantity)  {
		 MenuItem newItem = new MenuItem(name,price,quantity);
	     if(items.length <= numItems) {
	    	 System.out.println("ERROR: Cannot add " + name);
	    	 System.out.println("Cannot have more than " + items.length +
	    			 " items");
	    	 return false;
	    	 }
	     int  i = find(name);
	     if(i!=-1)
	     {
	    	 items[i].setQuantity(newItem.getQuantity() +
	    			 items[i].getQuantity());
	                return true;
	     }
	     else
	            {
	                items[numItems] = newItem;
	                numItems++;
	                return true;
	            }
	     }
	 
	 //find method
	 /** 
		 * searches array and returns index of matching MenuItem and 
		 * @param name name of the menu item
		 * @return i (index of item) if item exists in array 
		 * @return -1 if item does not exist
		 */
	 public int find(String name) {
		MenuItem item = new MenuItem(name, 0, 0);
		for (int i = 0; i < numItems; i++) {
			 if(item.equals(items[i])) {
				 return i;
			 }
		}
		return -1;
	}
	 
	 //getTotalBeforeTax method
	 /** calculate the total value of items in order
	  *  @return total value of all items
	  */
	public double getTotalBeforeTax() {
		double total = 0;
		for (int i = 0; i < numItems; i++) {
			total += items[i].getQuantity() * 
					items[i].getPrice();
			}
		return total;
	}
	
	//getTax method
	/**
	 * @param taxRate is the given tax rate
	 * @return tax to be payed on Order
	 */
	public double getTax(double taxRate) {
		double tax = taxRate * getTotalBeforeTax();
		return tax;
	}
	
	//getTip method
	/**
	 * @param percentage tip percentage
	 * @return tip to be paid on Orders total
	 */
	public double getTip(double percentage) {
		double tip = getTotalBeforeTax() * percentage;
		return tip;
	}
	
	//getNumMenuItems method
	/**
	 * @return number of MenuItems
	 */
	public int getNumMenuItems() {
		return numItems;
		}
	
	//getTotalQuantity method
	/**
	 * sums and returns the quantities of all MenuITems in Order
	 * @return totalQuantity the quantities of MenuItems on the Order
	 */
	public int getTotalQuantity() {
		int totalQuantity = 0;
		for(int i = 0; i < numItems; i++) {
			totalQuantity += items[i].getQuantity();
			}
		return totalQuantity;
		}
	
	//toString method
	/** formats and returns a string representation of Order information
	 * @return string representation of Order
	 */
	public String toString(){
		String menuStuff = "";
		for(int i = 0; i < numItems; i++) {
			menuStuff += items[i].toString();
		}
		String name = restaurant;
		int numberOfMenuItems = numItems;
		double OrderTotalBeforeTax = getTotalBeforeTax();
		double amountTaxToBeAdded = getTax(taxRate);
		double amountTipToBeAdded = getTip(percentage);
		double OrderTotal = OrderTotalBeforeTax + amountTaxToBeAdded +
				amountTipToBeAdded;
		String zero = "*******************************************************************************";
		String one = name;
		String two = "*******************************************************************************";
		String three = "Item" + "\t\t\t" + "Price" + "\t\t"
		+ "Qty" + "\t\t" + "Total";
		String four = "--------------------------------------------------------------------------------";
		String five = menuStuff;
		String six = "--------------------------------------------------------------------------------";
		String seven = String.format("%.2f", OrderTotalBeforeTax);
		seven = "Total: " + "\t" + "$" + seven;
		String eight =String.format("%.2f", amountTaxToBeAdded);
		eight = "Tax:" + "\t" + "$" + eight;
		String nine = String.format("%.2f", amountTipToBeAdded);
		nine = "Tip:" + "\t" + "$" + nine;
		String ten = "--------------------------------------------------------------------------------";
		String eleven = String.format("%.2f", OrderTotal);
		eleven = "Grand total: $" +  eleven;
		String twelve = "Total Menu items: " + numberOfMenuItems;
		return ("\n" + zero + "\n\t\t" + one +"\n" + two + "\n" + three + "\n" + four + "\n" + 
		five + "\n" + six + "\n" + seven + "\n" + eight + "\n" +
				nine + "\n" + ten + "\n" + eleven + "\n" + twelve);
	}
}
