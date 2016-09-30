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
public class Order {
	
	private int header;
	private List<Line> lines =  new ArrayList<>();
	
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	
	
	// check if it is an valid order or not
	public boolean validate() {
		for (Line l : this.getLines()) {
			if (l.getQuantity() <= 0 || l.getQuantity() > 5) {
				return false;
			}
		}
		return true;
	}
	/*private boolean validate(Order order) {
		boolean valid = false;
		for (Line l : this.getLines()) {
			if (l.getQuantity() > 0 && l.getQuantity() <= 5) {
				valid = true;
				return valid;
			}
		}
		return valid;
	}*/
}
