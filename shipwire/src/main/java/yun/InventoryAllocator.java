/**
 * 
 */
package yun;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xuey
 *
 */
public class InventoryAllocator {

	private int[] inventory;
	
	
	public InventoryAllocator() {}
	
	public InventoryAllocator(int[] invetory) {
		this.inventory = invetory;
	}
	
	
	public Result allocateInventory(Order order) {
		int[] dataPO = {0, 0, 0, 0, 0};
		int[] dataS = {0, 0, 0, 0, 0};
		int[] dataB = {0, 0, 0, 0, 0};
		Result result = new Result();
		
		if (order.validate()) {
			for (Line l : order.getLines()) {
				process(l, dataPO, dataS, dataB);
			}
			result.setHeader(order.getHeader());
			result.setProdOrder(dataPO);
			result.setSatisfiedOrder(dataS);
			result.setBackOrder(dataB);
		}
		return result;
	}
	
	
	// inventory update
	private void process(Line ln, int[] order, int[] satisfiedOrder, int[] backOrder) {
		int index = ln.convertIndex();
		order[index] = ln.getQuantity();
		if (inventory[index] >= order[index]) {
			satisfiedOrder[index] = order[index];	
			inventory[index] = inventory[index] - order[index];
		}
		else {
			backOrder[index] = order[index];
		}
	}
	
	
	public int[] getInventory() {
		return inventory;
	}

	public void setInventory(int[] inventory) {
		this.inventory = inventory;
	}
	
	boolean isEmpty() {
		for (int i=0; i<inventory.length; i++) {
			if (inventory[i] != 0) 
				return false;
		}
		return true;
	}

}