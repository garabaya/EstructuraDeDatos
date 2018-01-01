/**
 * 
 */
package arbolBinarioBusqueda;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class Node implements Comparable{
	private Object data;
	private Node left,right;
	
	public Node(Object data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Comparable<Object> data) {
		this.data = data;
	}

	/**
	 * @return the father
	 */
//	public Node getFather() {
//		return father;
//	}

	/**
	 * @param father the father to set
	 */
//	public void setFather(Node father) {
//		this.father = father;
//	}

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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return ((Comparable<Object>)this.data).compareTo(((Node)o).getData());
	}
	
	public int hasChild() {
		int count=0;
		if (this.getLeft()!=null) count++;
		if (this.getRight()!=null) count++;
		return count;
	}


	
}
