/**
 * 
 */
package pilaColaDinamicas;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class Element {
	private Object data;
	private Element next;
	
	public Element(Object data) {
		this.data=data;
		this.next=null;
	}

	/**
	 * @return the next
	 */
	public Element getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Element next) {
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * Se sobreescribe para que aplique sobre el objeto data directamente
	 */
	@Override
	public String toString() {
		return this.data.toString();
	}
	

}
