/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

/**
 *
 * @author yasin93
 */

/**
 * Tostring med rekursion
 * getNode med rekursion
 * Ta bort size 
 * 
 */
public class SingleLinkedListGetNodeToStringSize<E> {
    
    private static class Node<E> {
		private E data;
		private Node<E> next;
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;

	public SingleLinkedListGetNodeToStringSize(){
		head = null;
	}

	public void add(int index, E item) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		}else{
			Node<E> node = getNode(head,index - 1);
			addAfter(node, item);
		}
	}
	private void addFirst(E item) {			
		head = new Node<E>(item, head);
	}

	private Node<E> getNode(Node<E> node, int index) {
		if(node!=null && index!=0)
			return getNode(node.next,index-1);
		return node;
	}

	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
	}

	private String toString(Node<E> p){
	    if(p.next!=null) return p.data.toString()+" ==> "+toString(p.next);
	    return p.data.toString();
	 }

	@Override
	public String toString() {
		if(head!=null) return "["+toString(head)+"]";
	       return "[]";

	}
	
	public int size(){
		int size=0;
		Node<E> node = head;
		while(node!=null){
			size++;
			node=node.next;
		}
		return size;
	}
        
        public static void main(String[] args){
            SingleLinkedListGetNodeToStringSize<String> list = new SingleLinkedListGetNodeToStringSize<String>();
		System.out.println(list+""+list.size());
        for(int i=0;i<=3;i++)
            list.add(i,"Sträng "+(i+1));
        list.add(0,"först");
        list.add(5,"sist");
		System.out.println(list+""+list.size());
        }
}
