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
 * Find Metod för träden
 * och print metoden 
 * @author yasin93
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private static class Node<E>{
		private E data;
		private Node<E> left,right;
		private Node(E d){
			data=d;
			left=right=null;
		}
		@Override
		public String toString(){
			return data.toString();
		}
	}
	
	private Node<E> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	private void printTree(Node<E> node,Queue<Node<E>> q, Queue<Integer> level,int nodeL){
		System.out.print(node+" ");
		if(node!=null){
			q.offer(node.left);
			level.offer(nodeL+1);
			q.offer(node.right);
			level.offer(nodeL+1);
		}
		while(!q.isEmpty()){
			if(level.poll()>nodeL){
				System.out.println();
				nodeL++;
			}
			printTree(q.poll(),q,level,nodeL);
		}
	}
	
	public void printTree(){
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		Queue<Integer> level = new LinkedList<Integer>();
		printTree(root,q,level,1);
	}
	
	private boolean add(E data,Node<E> node){
		if(data.compareTo(node.data)==0)
			return false;
		else if(data.compareTo(node.data)<0)
			if(node.left==null){
				node.left = new Node<E>(data);
				return true;
			}else
				return add(data,node.left);
		else
			if(node.right==null){
				node.right = new Node<E>(data);
				return true;
			}else
				return add(data,node.right);
	}
	public boolean add(E data){
		if(root==null){
			root = new Node<E>(data);
			return true;
		}else{
			return add(data,root);	
		}
	}
	
	public E find(E target){
		return find(target, root);
	}
	
	private E find(E target, Node<E> node){
		if( node==null)
			return null;
		if(target.compareTo(node.data)==0)
			return node.data;
		if(target.compareTo(node.data)<0)
			return find(target,node.left);
		return find(target,node.right);
	}
	
	public static void buildTree(BinarySearchTree<String> b){
		b.add("H");
		b.add("B");
		b.add("N");
		b.add("A");
		b.add("E");
		b.add("C");
		b.add("F");
		b.add("D");
		b.add("DE");
	}
	public static void main(String[] args) {

		BinarySearchTree<String> bst= new BinarySearchTree<String>();
		buildTree(bst);
		System.out.println(bst.find("N")+" "+bst.find("U"));
		bst.printTree();
		  
	}
}
