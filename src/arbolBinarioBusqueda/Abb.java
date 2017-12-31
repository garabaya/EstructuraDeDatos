/**
 * 
 */
package arbolBinarioBusqueda;

/**
 * @author Ruben Garabaya Arenas
 *
 */
public class Abb {
	private Node root;
	
	public Abb(Object root) {
		this.root=new Node(root);
	}
	
	public boolean searchNode(Object elementToSearch) {
		Node nodeToSearch = new Node(elementToSearch);
		boolean found=false;
		Node position = this.root;
		if (elementToSearch.getClass().equals(this.root.getData().getClass())) {
			while (position!=null && !found) {
				if (position.compareTo(nodeToSearch)<0) {
					position=position.getRight();
				}else if (position.compareTo(nodeToSearch)>0) {
					position=position.getLeft();
				}else found=true;
			}
		}		
		return found;
	}
	
	//Insertar un nodo al árbol
	//Devuelve si se ha insertado
	public boolean addNode(Object elementToInsert) {
		Node nodeToInsert = new Node(elementToInsert);
		boolean inserted=true;
		if (!elementToInsert.getClass().equals(this.root.getData().getClass())){
			inserted=false;
		}else {
			Node position = this.root;
			Node father = null;
			boolean right = false;
			while (position!=null && inserted) {
				if (position.compareTo(nodeToInsert)<0) {
					right=true;
					father=position;
					position=position.getRight();
				}else if (position.compareTo(nodeToInsert)>0) {
					right=false;
					father=position;
					position=position.getLeft();
				}else inserted=false;
			}
			if (inserted) {
				if (right) father.setRight(nodeToInsert);
				else father.setLeft(nodeToInsert);
			}
		}
		return inserted;
	}
		
	//Elimina un nodo si existe y devuelve true. Devuelve false si no existe
	public boolean removeNode(Object objectToRemove) {
		Node nodo = new Node(objectToRemove);
		Boolean respuesta=false;
		Node posicion = this.root;
		while (posicion.compareTo(nodo)!=0 && posicion!=null) {
			if (posicion.compareTo(nodo)>0) posicion=posicion.getRight();
			else posicion=posicion.getLeft();
		}
		if (posicion!=null) {
			respuesta=true;
			//TODO
		}
		return respuesta;
	}
	
	//Devuelve una lista con los nodos en preorden
	public NodeList<Object> pre(){
		return pre(this.root);
	}
	//Método privado recursivo que devuelve una lista con los nodos en preorden del sub-árbol
	//	cuyo nodo raíz es el nodo pasado como argumento
	private NodeList<Object> pre(Node root2) {
		NodeList<Object> lista = new NodeList<Object>();
		//Si hay nodo...
		if (root2!=null) {//RID
			//Añadimos el nodo raiz a la lista
			lista.add(root2.getData());
			//añadimos la lista de nodos en preorden de la rama izquierda
			if (root2.getLeft()!=null) lista.addAll(pre(root2.getLeft()));
			//añadimos la lista de nodos en preorden de la rama derecha
			if (root2.getRight()!=null) lista.addAll(pre(root2.getRight()));
		}
		return lista;
	}
	
	//Devuelve una lista con los nodos en inorden
	public NodeList<Object> in(){
		return in(this.root);		
	}
	//Método privado recursivo que devuelve una lista con los nodos en inorden del sub-árbol
	//	cuyo nodo raíz es el nodo pasado como argumento
	private NodeList<Object> in(Node root2) {
		NodeList<Object> lista = new NodeList<Object>();
		//Si hay nodo...
		if (root2!=null) {//IRD
			//añadimos la lista de nodos en inorden de la rama izquierda
			if (root2.getLeft()!=null) lista.addAll(in(root2.getLeft()));
			//Añadimos el nodo raiz a la lista
			lista.add(root2.getData());
			//añadimos la lista de nodos en inorden de la rama derecha
			if (root2.getRight()!=null) lista.addAll(in(root2.getRight()));
			
		}
		return lista;
	}
	
	//Devuelve una lista con los nodos en postorden
	public NodeList<Object> post(){
		return post(this.root);		
	}
	//Método privado recursivo que devuelve una lista con los nodos en postorden del sub-árbol
	//	cuyo nodo raíz es el nodo pasado como argumento
	private NodeList<Object> post(Node root2) {
		NodeList<Object> lista = new NodeList<Object>();
		//Si hay nodo...
		if (root2!=null) {//IDR
			//añadimos la lista de nodos en inorden de la rama izquierda
			if (root2.getLeft()!=null) lista.addAll(post(root2.getLeft()));
			//añadimos la lista de nodos en inorden de la rama derecha
			if (root2.getRight()!=null) lista.addAll(post(root2.getRight()));
			//Añadimos el nodo raiz a la lista
			lista.add(root2.getData());
			
		}
		return lista;
	}

}
