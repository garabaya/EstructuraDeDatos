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
		Abb arbol = new Abb("Julio");
		arbol.addNode("Emilio");
		arbol.addNode("Olga");
		arbol.addNode("Carlos");
		arbol.addNode("Henry");		
		arbol.addNode("Fermín");
		arbol.addNode("Gloria");
		arbol.addNode("Inma");
		arbol.addNode("Luis");
		arbol.addNode("Silvia");
		arbol.addNode("Pedro");
		System.out.println("En postorden");
		arbol.post().print();
		System.out.println();
		System.out.println("En inorden");
		arbol.in().print();
		System.out.println();
		arbol.removeNode("Emilio");
		System.out.println("En preorden");
		arbol.pre().print();
		System.out.println();
		String buscado = "Pedro";
		Object encontrado = arbol.searchNode(buscado);
		if (encontrado!=null) System.out.println(encontrado + " si está");
		else System.out.println(buscado + " no está");
		buscado = "Emilio";
		encontrado = arbol.searchNode(buscado);
		if (encontrado!=null) System.out.println(encontrado + " si está");
		else System.out.println(buscado + " no está");
	}

}
