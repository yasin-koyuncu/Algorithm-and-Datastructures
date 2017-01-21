package stack_datastructure;

public class NB9LinkedStack<E> implements LinkedStackInt<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	private Node<E> top;
	private int size;

	public NB9LinkedStack() {
		top = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public E push(E obj) {
		top = new Node<E>(obj, top);
		size++;
		return obj;
	}

	@Override
	public E peek(int element) {
		Node<E> tmp = top;
		if (tmp != null) {
			for (int i = -1; i < element - 1; i++) {
				if (tmp != null) {
					tmp = tmp.next;
				}
			}

			return tmp.data;
		} else
			return null;
	}

	@Override
	public E pop(int element) {
		// TODO Auto-generated method stub
		Node<E> tmp = top;
		E tmp2 = null;
		if (tmp != null) {
			size--;

			if (element == 0) {
				top = top.next;
				return tmp.data;
			} else {
				for (int i = 0; i < element - 1 && tmp != null; i++) {
					tmp = tmp.next;

				}// Kommer till elementet innan

				tmp2 = tmp.next.data;// Kopierar data som ska returneras
				tmp.next = tmp.next.next;// Tar bort given element

				return tmp2;
			}
		}
		else return null;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = top;
		if (p != null) {
			while (p.next != null) {
				sb.append(p.data.toString());
				sb.append(" <== ");
				p = p.next;
			}
			sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public E flush() {
		// TODO Auto-generated method stub
		Node<E> node = top;
		while (node != null) {

			if (node.next == null)
				break;
			else
				node = node.next;
		}

		top = null;
		return node.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NB9LinkedStack<Integer> list = new NB9LinkedStack<Integer>();
		System.out.println(list.push(1));
		list.push(2);
		list.push(3);
		list.push(4);
		System.out.println(list.toString());
		System.out.println(list.peek(3));
		System.out.println(list.toString());
		// System.out.println(list.pop(0));
		System.out.println(list.flush());
		System.out.println(list.toString());
		System.out.println(list.peek(1));
		System.out.println(list.pop(2));
	}

}
