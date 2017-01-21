/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

import java.util.Scanner;

/**
 *
 * @author yasin93
 */
public class StackCharLinkedList {
    
    private static class Node{
		private char data;
		private Node next;		
		private Node(char d, Node n){
			data=d;
			next=n;
		}
	}
	
	private Node top;
	
	public StackCharLinkedList(){
		top=null;
	}
	
	public char push(char c){
		top = new Node(c,top);
		return c;
	}
	
	public char pop(){
		if(top==null) return 0;
		char result = top.data;
		top=top.next;
		return result;
	}
        
        	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StackCharLinkedList st = new StackCharLinkedList();
		for(int i=0;i<s.length();i++)
			st.push(s.charAt(i));
		boolean palindrom = true;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)!=st.pop()) palindrom = false;
		if(palindrom)
			System.out.println("Palindrom");
		else
			System.out.println("Ej palindrom");
		sc.close();
	}
}
