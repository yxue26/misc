/**
 * 
 */
package yun;

/**
 * @author xuey
 *
 */
public class Line {

	private String product;
	private int quantity;
	
	public Line(String product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	// convert the product name into index
	public int convertIndex() {
		return (int) this.product.charAt(0) - (int) 'A';
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
