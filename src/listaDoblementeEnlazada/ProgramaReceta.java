package listaDoblementeEnlazada;

public class ProgramaReceta {

	public static void main(String[] args) {
		
		//Inicializar la lista de pasos de una receta
		ListaDobEnl receta = new ListaDobEnl();//lista vacía
		
		//Añadir nodos a la lista
		receta.addNode(new Node("Encender el horno"));
		receta.addNode(new Node("Sacar la pizza de la nevera"));
		receta.addNode(new Node("Meter la pizza en el horno"));
		receta.addNode(new Node("Sacar la pizza del horno"));
		receta.addNode(new Node("Apagar el horno"));

		//Contar el número de elementos que tiene la lista
		System.out.println("Contar los pasos de la receta");
		System.out.println("Esta receta tiene "+receta.getCount()+ " pasos");
		System.out.println();
		
		//Mostrar el elemento que hay en una posición concreta de la lista
		int pos=2;
		System.out.println("Mostrar el paso "+pos);
		Node paso = receta.getNode(pos);
		if (paso!=null) {
			System.out.println("El paso "+pos+" es: "+paso.getText());
		}else {
			System.out.println("No existe el paso "+pos);
		}
		System.out.println();
		//Comprobar si un elemento está en la lista (por posición)
		pos=1;
		System.out.println("Comprobar si existe el paso "+pos);
		paso = receta.getNode(pos);
		if (paso!=null) {
			System.out.println("Sí existe el paso "+pos);
		}else {
			System.out.println("No existe el paso "+pos);
		}
		System.out.println();
		//Comprobar si un elemento está en la lista (por texto)
		String texto="Echar mostaza a la pizza";
		System.out.println("Comprobar si existe el paso: "+texto);
		int posicion = receta.getPosition(texto);
		if (posicion>=0) {
			System.out.println(texto+" sí está en la receta");
		}else {
			System.out.println(texto+" no está en la receta");
		}
		System.out.println();
		
		//Imprimir la lista
		System.out.println("Pasos de la receta:");
		receta.printList();
		System.out.println();
		
		//Insertar un elemento nuevo
		System.out.println("Hemos añadido un paso al final y otro en la posición 1:");
		receta.addNode(new Node("Comerse la pizza"));
		receta.addNode(1,new Node("Abrir la nevera"));
		receta.printList();
		System.out.println();
		
		//Sacar un elemento concreto de la lista
		Node pasoEliminar = receta.getNode(4);
		receta.deleteNode(pasoEliminar.getText());
		System.out.println("Paso eliminado: "+ pasoEliminar.getText());
		System.out.println();
		System.out.println("Ahora la receta tiene estos pasos:");
		receta.printList();
		System.out.println();
		
		//Sacar el elemento que ocupa una posición en la lista
		receta.deleteNode(2);
		System.out.println("Paso eliminado: "+2);
		System.out.println();
		System.out.println("Ahora la receta tiene estos pasos:");
		receta.printList();
		System.out.println();
		
		//Concatenar dos listas
		Node pasoCafe = new Node("Calentar café");
		ListaDobEnl recetaCafe = new ListaDobEnl(pasoCafe);
		recetaCafe.addNode(new Node("Echar azúcar"));
		recetaCafe.addNode(new Node("Tomarse el café"));
		System.out.println("Receta de café:");
		recetaCafe.printList();
		System.out.println();
		System.out.println("Recetas concatenadas:");
		ListaDobEnl listaConcatenada = ListaDobEnl.concat(receta, recetaCafe);
		listaConcatenada.printList();
		System.out.println();
		
		//Reemplazar un elemento de la lista
		listaConcatenada.replace(listaConcatenada.getPosition("Echar azúcar"), new Node("Echar sacarina"));
		System.out.println("Cambiando el azúcar por sacarina:");
		listaConcatenada.printList();
		
		
	}

}
