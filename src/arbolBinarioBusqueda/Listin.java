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
		arbol.addNode("Julio");
		arbol.addNode("Andrés");
		arbol.addNode("María");		
		arbol.addNode("Juana");
		arbol.addNode("Teresa");
		arbol.addNode("Aitor");
		arbol.addNode("Inma");
		System.out.println("En postorden");
		arbol.post().print();
		System.out.println();
		System.out.println("En inorden");
		arbol.in().print();
		System.out.println();
		arbol.removeNode("Inma");
		arbol.removeNode("Juana");
		System.out.println("En preorden");
		arbol.pre().print();
		System.out.println();
		String buscado = "Pepe";
		Object encontrado = arbol.searchNode(buscado);
		if (encontrado!=null) System.out.println(encontrado + " si está");
		else System.out.println(buscado + " no está");
		buscado = "Juana";
		encontrado = arbol.searchNode(buscado);
		if (encontrado!=null) System.out.println(encontrado + " si está");
		else System.out.println(buscado + " no está");
	}

}
