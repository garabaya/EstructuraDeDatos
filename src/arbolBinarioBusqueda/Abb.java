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
	
	public <T extends Comparable> Abb(T root) {
		this.root=new Node(root);
	}
	//Devuelve el objeto buscado o null si no lo encuentra
	public <T extends Comparable> Object searchNode(T elementToSearch) {
		Node nodeToSearch = new Node(elementToSearch);
		Node nodeFound = this.searchNode(nodeToSearch);
		if (nodeFound!=null)	return nodeFound.getData();
		else return null;
	}
	//Devuelve el Nodo buscado o null si no lo encuentra
	private Node searchNode(Node elementToSearch) {
		boolean found=false;
		Node position = this.root;
		if (elementToSearch.getData().getClass().equals(this.root.getData().getClass())) {
			while (position!=null && !found) {
				if (position.compareTo(elementToSearch)<0) {
					position=position.getRight();
				}else if (position.compareTo(elementToSearch)>0) {
					position=position.getLeft();
				}else found=true;
			}
		}
		if (found) return position;
		else return null;
	}
	
	//Insertar un nodo al árbol
	//Devuelve si se ha insertado
	public <T extends Comparable> boolean addNode(T elementToInsert) {
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
		
	//Elimina un nodo y devuelve el nodo eliminado o null si no lo encuentra
	public <T extends Comparable> Object removeNode(T objectToRemove) {
		Node nodeToRemove = new Node(objectToRemove);
		Node nodeFound = this.searchNode(nodeToRemove);
		Object resp=null;
		if (nodeFound!=null) {
			resp = nodeFound.getData();
			Node father = this.getFather(nodeFound);
			if (nodeFound.hasChild()==0){//Caso 1: No tiene hijos
				if (father.compareTo(nodeFound)<0) father.setRight(null);
				else father.setLeft(null);
			}else if(nodeFound.hasChild()==1) {//Caso 2: Tiene 1 hijo
				Node child;
				if (nodeFound.getLeft()!=null) child=nodeFound.getLeft();
				else child=nodeFound.getRight();
				if (father.compareTo(nodeFound)<0) father.setRight(child);
				else father.setLeft(child);
			}else {//Caso 3: Tiene 2 hijos
				Node leftChild = nodeFound.getRight();//Por la rama derecha buscamos la hoja izquierda
				while (leftChild.getLeft()!=null) {
					leftChild=leftChild.getLeft();
				}
				Node grandpa = this.getFather(leftChild);//Hay que guardar quien es el padre del nodo que hay que subir antes de hacerlo.
				//Paso 1: Copiar los datos del último hijo de la rama izq. en el nodo a borrar
				nodeFound.setData(leftChild.getData());
				//Paso 2: El padre del último hijo(abuelo) de la rama izquierda debe apuntar al hijo derecho(nieto) si lo tiene (hijo izquierdo no puede tener)
				grandpa.setLeft(leftChild.getRight());				
			}
		}
		
		
		return resp;
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
			//añadimos la lista de nodos en postorden de la rama izquierda
			if (root2.getLeft()!=null) lista.addAll(post(root2.getLeft()));
			//añadimos la lista de nodos en postorden de la rama derecha
			if (root2.getRight()!=null) lista.addAll(post(root2.getRight()));
			//Añadimos el nodo raiz a la lista
			lista.add(root2.getData());
			
		}
		return lista;
	}
	//Para eliminar un nodo necesitamos saber quien es su padre
	private Node getFather(Node child) {
		boolean found=false;
		Node position = this.root;
		Node father = null;		
		while (position!=null && !found) {
			if (position.compareTo(child)<0) {
				father = position;
				position=position.getRight();
			}else if (position.compareTo(child)>0) {
				father=position;
				position=position.getLeft();
			}else found=true;		}
		
		return father;
	}
}
