/**
 * 
 */
package yun;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuey
 *
 */
public class ShipwireApp {
	/**
	 * @param args
	 *  {"Header": 1, "Lines": {"Product": "A", "Quantity": "1"}{"Product": "C", "Quantity": "1"}}
	    {"Header": 2, "Lines": {"Product": "E", "Quantity": "5"}}
		{"Header": 3, "Lines": {"Product": "D", "Quantity": "4"}}
		{"Header": 4, "Lines": {"Product": "A", "Quantity": "1"}{"Product": "C", "Quantity": "1"}}
		{"Header": 5, "Lines": {"Product": "B", "Quantity": "3"}}
		{"Header": 6, "Lines": {"Product": "D", "Quantity": "8"}}
	  
	 Input data
	 	1:A:1:C:1
		2:E:5
		3:D:4
		4:A:1:C:1
		5:B:3
		
	 Output data
	  	1: 1,0,1,0,0::1,0,1,0,0::0,0,0,0,0
		2: 0,0,0,0,5::0,0,0,0,0::0,0,0,0,5
		3: 0,0,0,4,0::0,0,0,0,0::0,0,0,4,0
		4: 1,0,1,0,0::1,0,0,0,0::0,0,1,0,0
		5: 0,3,0,0,0::0,3,0,0,0::0,0,0,0,0 	
	 */
	public static void main(String[] args) {
		
		if (args.length != 5) {
			System.err.println("[usage] java ShipwireApp <A> <B> <C> <D> <E>");
			return;
		}
		
		int[] inventory = new int[5];
		for (int i=0; i<5; i++) {
			inventory[i] = Integer.parseInt(args[i]);
		}
		
		InventoryAllocator inventoryAllocator = new InventoryAllocator(inventory);
		if (inventoryAllocator.isEmpty()) {
			System.out.println("All inventory is zero, system halts");
			return;
		}
		
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while (scanner.hasNextLine()) {
            String productLine = scanner.nextLine();
            String[] splits = productLine.split(":");
            Order order = new Order();
    		order.setHeader(Integer.valueOf(splits[0]));
    		List<Line> ls = new ArrayList<>();
    		for (int i=1; i<splits.length; i=i+2) {
    			Line l = new Line(splits[i], Integer.valueOf(splits[i+1]));
    			ls.add(l);
    		}
    		order.setLines(ls);
    		Result result = inventoryAllocator.allocateInventory(order);
    		System.out.println(result.toString());
        }
        scanner.close();
	}

}
