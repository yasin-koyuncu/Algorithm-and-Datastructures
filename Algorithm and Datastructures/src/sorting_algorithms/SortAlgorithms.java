/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author yasin93
 */
public class SortAlgorithms {

    public static int[] selectionSort(int[] value) {
        //Lägg selection sort algorithm
        int i, j, first, temp, index = 0;
        for (i = 0; i < value.length - 1; i++) {
            index = i;
            for (j = i + 1; j < value.length; j++) {
                if (value[j] < value[index]) {
                    index = j;
                }
            }
            temp = value[index];
            value[index] = value[i];
            value[i] = temp;
        }
        return value;
    }

    private static void mergeSort(int a[], int b[], int c[]) {
        int indexa = 0, indexb = 0, indexc = 0;

        while (indexa < a.length && indexb < b.length) {
            if (a[indexa] <= b[indexb]) {
                c[indexc++] = a[indexa];
                indexa++;
            } else {
                c[indexc++] = b[indexb];
                indexb++;
            }
        }

        while (indexa < a.length) {
            c[indexc++] = a[indexa];
            indexa++;
        }
        while (indexb < b.length) {
            c[indexc++] = b[indexb];
            indexb++;
        }
    }

    public static int[] mergeSort(int a[]) {

        if (a.length == 1) {
            return a;
        }

        int[] b = new int[a.length / 2];
        int[] c = new int[a.length - b.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];

        }
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i + a.length / 2];

        }

        mergeSort(b);
        mergeSort(c);
        mergeSort(b, c, a);

        return a;
    }

    public static int[] shellSort(int[] array) {
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    public static void insertSort(int[] a) {
        int data, dataIndex;
        for (int index = 1; index < a.length - 1; index++) {
            data = a[index];
            dataIndex = index;

            while (dataIndex > 0 && data < a[dataIndex - 1]) {
                a[dataIndex] = a[dataIndex - 1];
                dataIndex--;
            }
            a[dataIndex] = data;
        }

    }

    /**
     * SHELL SORT
     */
    public static int[] shell(int[] a) {
        int gap = a.length / 2;
        int data, dataIndex;

        while (gap > 0) {
            for (int index = gap; index < a.length; index++) {
                insertSort(a);
                if (gap == 2) {
                    gap = 1;
                } else {
                    gap = gap / 2;
                }

            }
        }
        return a;
    }

    /**
     * * HEAP SORT**
     */
    private static void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

    }

    /**
     * *Quick Sort *
     */
    private static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(int[] a, int first, int last) {
        if (last <= first) {
            return;
        }
        int pivotIndex = partition(a, first, last);
        quicksort(a, first, pivotIndex - 1);
        quicksort(a, pivotIndex + 1, last);
    }

    private static int partition(int[] a, int first, int last) {
        int index = first;
        for (int i = first; i < last; i++) {
            if (a[i] < a[last]) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, index, last);
        return index;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Radix sort
     */
    public static void radixSort(int[] arr) {

        Queue<Integer>[] buckets = new Queue[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<Integer>();
        }

        boolean sorted = false;
        int expo = 1;

        while (!sorted) {
            sorted = true;

            for (int item : arr) {
                int bucket = (item / expo) % 10;
                if (bucket > 0) {
                    sorted = false;
                }
                buckets[bucket].add(item);
            }

            expo *= 10;
            int index = 0;

            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    arr[index++] = bucket.remove();
                }
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        int[] value = {7, 2, 10, 3, 4, 5};
        int[] sort;
        //sort=selectionSort(value);
        //sort=insertionSort(value);
        //sort = mergeSort(value);
        //quicksort(value);
        //insertSort(value);
        //heapSort(value)
        radixSort(value);
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }

    }
}
