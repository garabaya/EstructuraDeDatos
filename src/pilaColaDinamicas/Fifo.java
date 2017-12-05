/**
 * Clase que implementa una cola
 */
package pilaColaDinamicas;

/**
 * @author Ruben
 *
 */
public class Fifo {
	private Element first,last;
	private int count;
	
	public Fifo() {
		init();
	}
	public void init() {
		this.first=null;
		this.last=null;
		this.count=0;
	}
	/**
	 * 
	 * @return Object
	 * Función "Primero"
	 */
	public Object first() {
		return this.first.getData();
	}
	
	public int count() {
		return this.count;
	}
	/**
	 * 
	 * @param object
	 * La función no devuelve nada. No se controla si se ha insertado correctamente
	 * 	porque no se esperan errores en una cola dinámica.
	 */
	public void queue(Object object) {
		Element element = new Element(object);
		//la cola está vacía
		if (isEmpty()) {
			this.first=element;
			this.last=element;
			//la cola no está vacía
		}else {
			this.last.setNext(element);
			this.last=element;
		}
		this.count++;
	}
	/**
	 * 
	 * @return Object
	 * devuleve el primer elemento de la cola
	 */
	public Object unqueue() {
		//si la cola no está vacía
		if (!isEmpty()) {
			Element oldFirst = new Element(this.first.getData());
			this.first=this.first.getNext();
			this.count--;
			return oldFirst.getData();
		}else return null;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void show() {
		Element nextElement = this.first;
		while (nextElement!=null) {
			System.out.println(nextElement);
			nextElement=nextElement.getNext();
		}
		System.out.println("    Count: "+this.count);
	}
}
