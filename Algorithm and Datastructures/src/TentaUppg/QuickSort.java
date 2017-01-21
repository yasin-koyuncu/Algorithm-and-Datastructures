/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

import java.util.Arrays;

/**
 *
 * @author yasin93
 */
public class QuickSort {
    
    public static void main(String[] args) {
		int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
		quicksort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void quicksort(int[] a) {
		quicksort(a,0,a.length-1);		
	}

	private static void quicksort(int[] a, int first, int last) {
		if(last<=first) return;
		int pivotIndex = partition(a,first,last);
		quicksort(a, first,pivotIndex-1);		
		quicksort(a, pivotIndex+1,last);
	}

	private static int partition(int[] a, int first, int last) {
		int index = first;
		for(int i=first;i<last;i++){
			if(a[i]<a[last]){
				swap(a,i,index);
				index++;
			}
		}
		swap(a,index, last);
		return index;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
}
