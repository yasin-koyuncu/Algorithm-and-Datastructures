package stack_datastructure;

import java.util.*;

public class NB9StackArrList<E> implements StackInt<E> {

	private ArrayList<E> list;
	private int size;
	private int top;

	public NB9StackArrList(int capacity) {
		list = new ArrayList(capacity);
		size = 0;
		top = -1;
	}

	@Override
	public E push(E obj) {
		// TODO Auto-generated method stub
		top++;
		size++;
		list.add(obj);
		return obj;

	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.get(top);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E obj=list.remove(top);
		top--;
		size--;
		return obj;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return top==-1;
	}
	

	@Override
	public String toString() {
		return "NB9StackArrList [list=" + list + "top:"+top+" ]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NB9StackArrList<Integer> list=new NB9StackArrList<Integer>(10);
		System.out.println(list.push(3));
		System.out.println(list.push(1));
		list.push(10);
		list.push(12);
		list.push(7);
		
	
		System.out.println(list.toString());
		System.out.println(list.pop());
		System.out.println(list.empty());
		System.out.println(list.toString());
		System.out.println(list.peek());
	}

}
