/**
 * 
 */
package arbolBinarioBusqueda;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class Listin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Abb arbol = new Abb("Pedro");
		arbol.addNode("Pepe");
		arbol.addNode("María");
		arbol.addNode("Andrés");
		arbol.addNode("Julio");
		arbol.addNode("Juana");
		//arbol.removeNode("Juana");
		arbol.addNode("Teresa");
		arbol.addNode("José");
		arbol.addNode("Inma");
		System.out.println("En postorden");
		arbol.post().print();
		System.out.println();
		System.out.println("En inorden");
		arbol.in().print();
		System.out.println();
		System.out.println("En preorden");
		arbol.pre().print();
		System.out.println();
		if (arbol.searchNode("Pepe")) System.out.println("Pepe si está");
		else System.out.println("Pepe no está");
		if (arbol.searchNode("Juana")) System.out.println("Juana si está");
		else System.out.println("Juana no está");
	}

}
