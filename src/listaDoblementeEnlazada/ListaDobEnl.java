package listaDoblementeEnlazada;
/**
* La clase ListaDobEnl es una lista doblemente enlazada
**/
public class ListaDobEnl {
	private Node first;//primer nodo
	private Node last;//ultimo nodo
	private int count;//contador de nodos
	
	
	//Constructor
	public ListaDobEnl() {
		this.first=null;
		this.last=null;
		this.count=0;
	}

	//El constructor inicializa la lista con un nodo
	public ListaDobEnl(Node primero) {
		//El único nodo es el primero y último a la vez
		this.first = primero;
		this.last = primero;
		this.count=1;//La lista se inicializa con un nodo
	}

	// getters/setters
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node primero) {
		this.first = primero;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node ultimo) {
		this.last = ultimo;
	}

	public int getCount() {
		return count;
	}
	/**
	 * Añade un nodo al final
	 **/
	public void addNode(Node nodo) {
		if (this.first==null) {
			this.first=nodo;
			this.last=nodo;
		}else {
			nodo.setPrev(this.last);
			this.last.setNext(nodo);
			this.last=nodo;
		}
		
		this.count++;
	}
	/** 
	 * Añade un nodo al principio
	 **/
	private void addFirstNode(Node nodo) {
		if (this.first==null) {
			addNode(nodo);
		}else {
			this.first.setPrev(nodo);
			this.first=nodo;
			this.count++;
		}
	}
	/** 
	 * Añade un nodo en la posición indicada
	 **/
	public void addNode(int pos,Node nodo) {
		if (pos==0) addFirstNode(nodo);
		else if (pos==this.count) addNode(nodo);
		else if (pos>0 && pos<this.count) {
			Node anterior = this.getNode(pos-1);
			Node posterior = this.getNode(pos);
			nodo.setPrev(anterior);
			nodo.setNext(posterior);
			anterior.setNext(nodo);
			posterior.setPrev(nodo);
			this.count++;
		}
	}
	/**
	* Método que devuelve la posición cuyo texto conincida con la String pasada
	**/
	public int getPosition(String texto) {
		if (this.first==null) {
			return -1;
		}
		//Recorremos la lista nodo a nodo para buscar el nodo con el texto indicado
		int pos=0;
		boolean encontrado=false;
		Node nodo = this.first;
		//Si no encontramos el nodo y no hemos llegado al final pasamos al siguiente
		while (!encontrado && nodo!=null) {
			if (!nodo.getText().equals(texto)) {
				nodo = nodo.getNext();
				pos++;
			}else {
				encontrado=true;
			}
		}
		if (encontrado) return pos;
		else return -1;//Si no se encuentra el elemento devuelve -1
	}
	/**
	 * Método que devuelve el nodo en la posición indicada
	 **/
	public Node getNode(int posicion) {
		if (posicion>=this.count || posicion<0) return null;//si se pide una posición fuera del rango devuelve null
		Node paso;
		//Recorremos la lista hasta la posición recibida.
		//Desde el principio o desde el final. Lo que esté más cerca
		if (posicion>this.count/2) {
			paso=this.last;
			for (int i=this.count-1; i>=posicion; i--) {
				if (i!=posicion) {
					paso = paso.getPrev();
				}
			}
		}else {
			paso=this.first;
			for (int i=0; i<=posicion; i++) {
				if (i!=posicion) {
					paso = paso.getNext();
				}
			}
		}		
		return paso;
	}
	/**
	 * Elimina el primer nodo cuyo texto coincida
	 * Devuelve el nodo eliminado o null si no lo ha encontrado
	 **/
	public Node deleteNode(String texto) {
		if (this.first==null)return null;
		Node nodo=this.first;
		while (nodo!=null) {
			if (nodo.getText().equals(texto)) {
				deleteNode(nodo);
				return nodo;
			}else nodo=nodo.getNext();
		}
		return null;
	}
	/**
	 * Elimina el nodo en la posición indicada
	 * Devuleve el nodo eliminado
	 **/
	public Node deleteNode(int pos) {
		if (pos<0 || pos>=this.count) return null;
		Node nodo=this.first;
		for (int i=0; i<pos;i++) {
			nodo = nodo.getNext();
		}
		deleteNode(nodo);
		return nodo;
	}
	/**
	 * Elimina el nodo
	 **/
	private void deleteNode(Node node) {
		if (node!=null) {
			if (this.first!=null) {
				Node nodo = this.first;
				for (int i=0; i<this.count;i++) {
					if (nodo.equals(node)) {
						//borrar
						Node anterior,siguiente;
						anterior = nodo.getPrev();
						siguiente = nodo.getNext();
						anterior.setNext(siguiente);
						siguiente.setPrev(anterior);
						this.count--;
						break;
					}else {
						nodo=nodo.getNext();
					}
				}
			}
		}		
		
	}
	/**
	 * Método de clase
	 * Concatenar dos listas
	 * Devuelve la lista resultante
	 **/
	public static ListaDobEnl concat(ListaDobEnl lista1,ListaDobEnl lista2) {
		//Creamos una nueva lista para no modificar las recibidas como parámetros
		ListaDobEnl listaConcatenada = new ListaDobEnl();
		Node nodo = lista1.getFirst();
		while (nodo!=null) {
			//Añadimos un nuevo nodo con el mismo texto para no pasar el nodo como referencia con sus punteros
			listaConcatenada.addNode(new Node(nodo.getText()));
			nodo=nodo.getNext();
		}
		nodo = lista2.getFirst();
		while (nodo!=null) {
			listaConcatenada.addNode(new Node(nodo.getText()));
			nodo=nodo.getNext();
		}
		return listaConcatenada;
	}
	public void printList() {
		Node nodo = this.first;
		int pos = 0;
		while (nodo!=null) {
			System.out.println(pos+"- "+nodo.getText());
			nodo=nodo.getNext();
			pos++;
		}
	}
	/**
	 * reemplaza el nodo que hay en la posición indicada por el nodo pasado como parámetro
	 **/
	public void replace(int pos, Node nodo) {
		this.deleteNode(pos);
		this.addNode(pos, nodo);
	}
	
	
}
