/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

/**
 *
 * Sök med binärsökning
 * Sök med find rekursion i en integer array
 */
public class IntegerarraySearchAndBinary {
    
    
    public static void main(String[] args) {
		
		int[] n1 = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
		int[] n2 = {3, 5, 14, 23, 23, 24, 28, 39, 41, 102, 106};
		System.out.println(search(n1,3));
		System.out.println(binarySearch(n2,23));
	}

	private static int binarySearch(int[] n, int target) {
		return binarySearch(n,target,0,n.length-1);
	}

	private static int binarySearch(int[] n, int target, int first, int last) {
		if(first>last) return -1;
		int middle=(first+last)/2;
		if(n[middle]==target) return middle;
		if(target<n[middle]) return binarySearch(n,target,first,middle-1);
		return binarySearch(n, target, middle+1, last);
	}

	private static int search(int[] n, int target) {
		return search(n, target, 0);
	}

	private static int search(int[] n, int target, int index) {
		if(index>=n.length) return -1;
		if(n[index]==target) return index;
		return search(n, target, index+1);
	}
}
