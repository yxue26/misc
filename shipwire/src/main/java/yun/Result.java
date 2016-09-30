/**
 * 
 */
package yun;


/**
 * @author xuey
 *
 */
public class Result {
	
	private int header;
	private int[] prodOrder;
	private int[] satisfiedOrder;
	private int[] backOrder;
	
	// {"Header": 1, "Lines": {"Product": "A", "Quantity": "1"},{"Product": "C", "Quantity": "4"}}
	// 1: 1,0,1,0,0::1,0,1,0,0::0,0,0,0,0

	public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

	public int[] getProdOrder() {
		return prodOrder;
	}

	public void setProdOrder(int[] prodOrder) {
		this.prodOrder = prodOrder;
	}

	public int[] getSatisfiedOrder() {
		return satisfiedOrder;
	}

	public void setSatisfiedOrder(int[] satisfiedOrder) {
		this.satisfiedOrder = satisfiedOrder;
	}

	public int[] getBackOrder() {
		return backOrder;
	}

	public void setBackOrder(int[] backOrder) {
		this.backOrder = backOrder;
	}

	
	public String toString() {
		String output = header + ": ";
		
		for (int i=0; i<prodOrder.length; i++) {
			output += prodOrder[i] + ",";
		}
		output = output.substring(0, output.length()-1) + "::";
		for (int i=0; i<satisfiedOrder.length; i++) {
			output += satisfiedOrder[i] + ",";
		}
		output = output.substring(0, output.length()-1) + "::";
		for (int i=0; i<backOrder.length; i++) {
			output += backOrder[i] + ",";
		}
		output = output.substring(0, output.length()-1);
		
		return output;
	}
	
}
