package listaDoblementeEnlazada;

public class Node {
	private Node next;
	private Node prev;
	private String text;
	
	public Node(String texto) {
		this.text=texto;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node siguiente) {
		this.next = siguiente;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node anterior) {
		this.prev = anterior;
	}
	public String getText() {
		return text;
	}
	public void setText(String texto) {
		this.text = texto;
	}
	
}
