/**
 * Extendemos la clase ArrayList para añadir el método "print", que imprime la lista
 */
package arbolBinarioBusqueda;

import java.util.ArrayList;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class NodeList<Object> extends ArrayList<Object>{

	public void print() {
		for(Object nodo:this) {
			System.out.println(nodo);
		}
	}

}
