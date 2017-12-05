/**
 * Este programa muestra los pasos para resolver Las Torres de Hanoi con 4 piezas o fichas
 * Utiliza 3 pilas para almacenar el estado de cada una de las torres
 * 	y una cola para gusrdar los pasos seguidos en la resolución.
 */
package pilaColaDinamicas;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class PilasYColas {
	static Lifo torre1,torre2,torre3;
	static Fifo movimientos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Las Torres de Hanoi\n");
		torre1 = new Lifo();
		torre2 = new Lifo();
		torre3 = new Lifo();
		movimientos = new Fifo();
		
		torre1.stack(4);
		torre1.stack(3);
		torre1.stack(2);
		torre1.stack(1);
		String movimiento="Colocar fichas en las torres.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre2.stack(torre1.unstack());
		movimiento="Ficha 1 de Torre 1 a Torre 2.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre1.unstack());
		movimiento="Ficha 2 de Torre 1 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre2.unstack());
		movimiento="Ficha 1 de Torre 2 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre2.stack(torre1.unstack());
		movimiento="Ficha 3 de Torre 1 a Torre 2.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre1.stack(torre3.unstack());
		movimiento="Ficha 1 de Torre 3 a Torre 1.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre2.stack(torre3.unstack());
		movimiento="Ficha 2 de Torre 3 a Torre 2.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre2.stack(torre1.unstack());
		movimiento="Ficha 1 de Torre 1 a Torre 2.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre1.unstack());
		movimiento="Ficha 4 de Torre 1 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre2.unstack());
		movimiento="Ficha 1 de Torre 2 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre1.stack(torre2.unstack());
		movimiento="Ficha 2 de Torre 2 a Torre 1.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre1.stack(torre3.unstack());
		movimiento="Ficha 1 de Torre 3 a Torre 1.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre2.unstack());
		movimiento="Ficha 3 de Torre 2 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre2.stack(torre1.unstack());
		movimiento="Ficha 1 de Torre 1 a Torre 2.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre1.unstack());
		movimiento="Ficha 2 de Torre 1 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		torre3.stack(torre2.unstack());
		movimiento="Ficha 1 de Torre 2 a Torre 3.";
		movimientos.queue(movimiento);
		System.out.println("Paso "+movimientos.count()+":");
		showTorres();
		
		System.out.println();
		reproducirPasos();
	}
	//el método show() tanto de las pilas como de las colas no saca los elementos
	private static void showTorres() {
		System.out.println("Torre 1");
		torre1.show();
		System.out.println("Torre 2");
		torre2.show();
		System.out.println("Torre 3");
		torre3.show();
		System.out.println();
	}
	//mostramos los pasos usando el método unqueue() simplemente por mostrar su funcionamiento.
	//Podríamos haberlo hecho con el método show() de la clase Fifo
	public static void reproducirPasos() {
		System.out.println("Pasos seguidos:");
		while (!movimientos.isEmpty()) {
			System.out.println(movimientos.unqueue());
		}
	}

}
