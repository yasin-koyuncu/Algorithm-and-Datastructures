package arraylist_datastructure;

import java.io.IOException;
import java.util.Arrays;

public class IntList {


		int size;
		int[] arr;
		
		public IntList(int capacity){
			arr= new int[capacity];
			size=0;
		}
		
		public void add(int element){
			arr[size]=element;
			size++;		
		}
		public void add(int index,int element) throws IOException{
			if(arr[index]==0&&index>=0&&index<arr.length){
				arr[index]=element;
				size++;
			}
			else
				throw new IOException("Denna plats är inte ledig");
		}
		public int get(int index){
			if(index>=0&&index<arr.length){
				return arr[index];
			}
			else return -1;   ///Felkod
		}
		
		public int indexOf(int element){
			for(int i=0;i<arr.length;i++){
				if(arr[i]==element)
					return i;
			}
			return -1;
		}
		
		public int remove(int index) {
			int tmp;
			if(index>=0&&index<arr.length){
				tmp=arr[index];
				arr[index]=0;
				for(int i=index;i<arr.length-1;i++){
					arr[i]=arr[i+1];
				}
				size--;
				return tmp;
			}
			else 
				return -1;
			
		}
		
		public void set(int index,int element){
			if(index>=0&&index<arr.length&&arr[index]==0){
				arr[index]=element;
				size++;
						
			}
			else if(index>=0&&index<arr.length&&arr[index]!=0){
				arr[index]=element;
			}
		}
		public int size(){
			return size;
		}

		@Override
		public String toString() {
			return "IntList [arr=" + Arrays.toString(arr) + "]";
		}
		
		
	
	
	
	public static void main(String[] args) throws IOException{
		IntList list=new IntList(10);
		list.add(4);
		list.add(5,2);
		
		System.out.println(list.toString());
		System.out.println(list.remove(0));
		System.out.println(list.toString());
		//System.out.println(list.remove(4));
		//System.out.println(list.toString());
		System.out.println(list.get(4));
		System.out.println(list.indexOf(2));
		list.add(3,5);
		System.out.println(list.toString());
		
	}
}
