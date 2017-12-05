/**
 * Clase que implemeta una Pila
 */
package pilaColaDinamicas;

/**
 * @author Ruben Garabaya Arenas
 * 05/12/17
 */
public class Lifo {
	private Element top;
	private int count;
	
	public Lifo() {
		init();
	}
	public void init() {
		this.top=null;
		this.count=0;
	}
	/**
	 * 
	 * @return Object
	 * Función "Cima"
	 */
	public Object top() {
		return this.top.getData();
	}
	
	public int count() {
		return this.count;
	}
	/**
	 * 
	 * @param object
	 * La función no devuelve nada. No se controla si se ha insertado correctamente
	 * 	porque no se esperan errores en una pila dinámica.
	 */
	public void stack(Object object) {
		Element element = new Element(object);
		//la pila está vacía
		if (isEmpty()) {
			element.setNext(null);
			this.top=element;
			//la pila no está vacía
		}else {
			Element oldTop = new Element(this.top.getData());
			oldTop.setNext(this.top.getNext());
			element.setNext(oldTop);
			this.top=element;
		}
		this.count++;
	}
	/**
	 * 
	 * @return Object
	 * devuleve el siguiente elemento de la pila
	 */
	public Object unstack() {
		//si la pila no está vacía
		if (!isEmpty()) {
			Element oldTop = new Element(this.top.getData());
			this.top=this.top.getNext();
			this.count--;
			return oldTop.getData();
		}else return null;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public void show() {
		Element nextElement = this.top;
		while (nextElement!=null) {
			System.out.println(nextElement);
			nextElement=nextElement.getNext();
		}
		System.out.println("    Count: "+this.count);
	}
}
