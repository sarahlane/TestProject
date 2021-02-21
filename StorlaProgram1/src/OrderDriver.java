/**
 * This class represents a driver for the Order class
 * @author Sarah Storla
 *
 */

public class OrderDriver {
    public static void main(String[] args)
    {
        Order orderOne = new Order("Metro State Cafe", 3);
        Order orderTwo = new Order("Jason R. Carter Science "
        		+ "Education Center Coffee Shop",30);
        orderOne.add("Soup", 5, 3);
        orderOne.add("Wrap", 7.5, 5);
        orderOne.add("Chips", 1.5, 7);
        orderOne.add("Soda", 1.5, 4);
        orderTwo.add("Coffee", 2.5, 4);
        orderTwo.add("Tea", 2, 6);
        orderTwo.add("Latte", 3.5, 4);
        orderTwo.add("Soda", 1.5, 8);
        orderTwo.add("Muffin", 4, 3);
        orderTwo.add("Cookie", 2, 2);
        orderTwo.add("Cookie", 2, 3);
        orderTwo.add("Latte", 3, 7);
        System.out.println(orderOne.toString());
        System.out.println("\n Wrap is at index " +
        		orderOne.find("Wrap"));
        System.out.println(orderTwo.toString());
        if(orderTwo.find("Hot Chocolate") == -1)
        	System.out.println("Item not available");
        
        
        
}
}