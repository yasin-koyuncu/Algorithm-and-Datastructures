package single_linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedListNew<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return  new Itr(head); //To change body of generated methods, choose Tools | Templates.
    }

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;
	private int size;
	private Node<E> tail;

	public SingleLinkedListNew() {
		head = null;
		size = 0;
	}

	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		}
		else if(index==size){
			Node<E> tmp=new Node<E>(item,null);
			//tmp=tail;
			tail.next=tmp;
			tail=tail.next;
			size++;
		}
		else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
			
		}
	}

	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}

	public boolean add(E item) {
		add(size, item);
		return true;
	}

	private void addFirst(E item) {
		if(head==null){
			head=new Node<E>(item,head);
			tail=head;
		}
		else
		head = new Node<E>(item, head);
		size++;
	}

	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		size++;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = head;
		if (p != null) {
			while (p.next != null) {
				sb.append(p.data.toString());
				sb.append(" ==> ");
				p = p.next;
			}
			sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}
	public E remove(int index){
		Node<E> p=head;Node<E> p2;
		if(index==0){
			p2=p;
			head=p.next;
			return p2.data;
		}
		else if(p!=null){
			for(int i=1;i<index;i++)
				p=p.next;
			
			p2=p.next;
			p.next=p.next.next;
			return p2.data;
		}
		//else
			//head=null;
		return null;
	}
	public static void main(String[] args) {
		SingleLinkedListNew<Integer> list=new SingleLinkedListNew<Integer>();
		list.add(0,1);
		list.add(0,2);
		list.add(1,3);
		list.add(2,4);
		list.add(4,5);
		list.add(5,2);
		System.out.println(list.toString());
		//System.out.println(list.remove(0));
		
		System.out.println(list.toString());
		//System.out.println(list.remove(1));
		System.out.println(list.toString());
		//list.add(0, 5);
               Iterator iter=list.iterator();//Funkar sedan prina ut allting på listan
                System.out.println(iter.next());
               
               
                 
		//System.out.println(list.toString());
	}
        
        private class Itr implements Iterator<E> {// nested class
		Node<E> current;
                Node<E> previous;
                Node<E> beforePrevious;
                
                boolean removeCalled;

		public Itr(Node<E> start) {
			current = start;
                        previous=null;
                        beforePrevious=null;
                        removeCalled=false;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			E returnValue = current.data;
                        beforePrevious=previous;
                        previous=current;
			current = current.next;
                        removeCalled=false;
			return returnValue;
		}

		@Override
		public void remove() {
			if(previous==null||removeCalled)
                            throw new IllegalStateException();
                        if(beforePrevious==null){
                            head=current;
                        }else{
                            beforePrevious.next=current;
                            previous=beforePrevious;
                        }
                        removeCalled=true;
                            
		}
	}
}
