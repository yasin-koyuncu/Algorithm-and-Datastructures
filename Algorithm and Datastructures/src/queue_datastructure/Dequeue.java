package queue_datastructure;
///EJ KOMPILERBAR**/
public class Dequeue<E> {

	private Node<E> firstNode;
	private Node<E> lastNode;
	private int size;

	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> previous;

		public Node(E data, Node<E> ref) {
			this.data = data;
			this.next = ref;

		}
	}

	public Dequeue() {
		firstNode = null;
		lastNode = null;
	}

	public boolean offerFirst(E obj) {

		Node<E> newNode = new Node<E>(obj, firstNode);

		if (firstNode != null)
			firstNode.previous = newNode;
		if (firstNode == null)
			lastNode = newNode;
		firstNode = newNode;
		return true;

	}

	public boolean offerLast(E obj) {
		Node<E> node = new Node<E>(obj, lastNode);
		if (lastNode != null) {
			lastNode.next = node;
		}
		if (lastNode == null) {
			firstNode = node;
		}
		lastNode = node;
		return true;

	}

	public E pollFirst() {
		Node<E> tmp = firstNode;
		Node<E> tmpFirst = firstNode.next;
		if (tmpFirst != null) {
			tmpFirst.previous = null;
		}
		if (tmpFirst == null) {
			lastNode = null;
		}
		firstNode = tmpFirst;
		size--;
		return tmp.data;
	}

	public E pollLast() {
		Node<E> tmp = lastNode;
		Node<E> tmpLast = lastNode.previous;
		if (tmpLast != null) {
			tmpLast.next = null;
		}
		if (tmpLast == null) {
			firstNode = null;
		}
		lastNode = tmpLast;

		size--;
		return tmp.data;
	}

	public boolean empty() {
		return (firstNode == null) && (lastNode == null);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = firstNode;
		if (p != null) {
			while (p!= null) {
				if(p.next==null)
					break;
				sb.append(p.data.toString());
				sb.append(" ");
				p = p.next;
			}
			//sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		Dequeue<Integer> que = new Dequeue<Integer>();

		que.offerFirst(2);
		que.offerFirst(5);
		que.offerFirst(4);
		// que.addFront(3);
		que.offerLast(10);
		que.offerLast(32);
		

		System.out.println(que.toString());
		System.out.println(que.pollFirst());
		System.out.println(que.pollLast());
	//	System.out.println(que.toString());
	}
}
