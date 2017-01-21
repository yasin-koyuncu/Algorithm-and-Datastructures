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
public class Heap {
    static final int SIZE = 1000;
	int[] a;
	int p;
	
	public Heap(){
		a = new int[SIZE];
		p=0;
	}
	
	public boolean insert(int data){
		if(p==SIZE) return false;
		a[p]=data;
		insertion(p);
		p++;
		return true;
	}

	private void insertion(int p) {
		if(p!=0 && a[p]<a[(p-1)/2]){
			int tmp=a[p];
			a[p]=a[(p-1)/2];
			a[(p-1)/2]=tmp;
			insertion((p-1)/2);
		}
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<p-1;i++){
			sb.append(a[i]);
			sb.append(",");
		}
		sb.append(a[p-1]);
		return sb.toString();
	}
        
        public static void main(String[] args) {
		Heap h = new Heap();
		h.insert(82);
		h.insert(41);
		h.insert(24);
		h.insert(30);
		h.insert(4);
		h.insert(19);
		h.insert(91);
		h.insert(12);
		System.out.println(h);
	}

}
