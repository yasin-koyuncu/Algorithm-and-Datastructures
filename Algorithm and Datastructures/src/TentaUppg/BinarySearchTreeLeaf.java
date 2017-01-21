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
public class BinarySearchTreeLeaf<E extends Comparable<E>> {
	
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
	
	public BinarySearchTreeLeaf(){
		root=null;
	}
	
	private void inOrder(Node<E> node, StringBuilder sb){
		if(node!=null){
			inOrder(node.left, sb);
			sb.append(": "+node.toString());
			inOrder(node.right, sb);
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		inOrder(root,sb);
		return sb.toString();
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
	private E minLeaf(Node<E> node){
		if(node.left==null)
			if(node.right==null)
				return node.data;
			else
				return minLeaf(node.right);
		return minLeaf(node.left);
	}	
	public E minLeaf(){
		if(root==null) return null;
		return minLeaf(root);
	}
        public static void buildTree(BinarySearchTreeLeaf<String> b){
		b.add("H");
		b.add("C");
		b.add("I");
		b.add("E");
		b.add("D");
		b.add("F");
	}
	public static void main(String[] args) {

		BinarySearchTreeLeaf<String> bst= new BinarySearchTreeLeaf<String>();
		buildTree(bst);
		System.out.println(bst.minLeaf());  
	}
}