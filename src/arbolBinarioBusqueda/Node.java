/**
 * 
 */
package arbolBinarioBusqueda;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class Node {
	private Comparable<Object> data;
	private Node left,right;
	
	public <T extends Comparable> Node(T data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public Comparable getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public <T extends Comparable> void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	public int compareTo(Node node) {
		return (this.data.compareTo(node.getData()));
	}
	
	public int hasChild() {
		int count=0;
		if (this.getLeft()!=null) count++;
		if (this.getRight()!=null) count++;
		return count;
	}


	
}
