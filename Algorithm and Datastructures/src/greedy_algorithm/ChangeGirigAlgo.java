/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy_algorithm;

/**
 *
 * @author yasin93
 */
public class ChangeGirigAlgo {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myChange =  change(789,new int[]{1000,500,100,50,20,10,5,1});
		
		if(myChange == null)
			System.out.println("GIck ej att lösa");
		else{
			for(int i = 0; i < myChange.length; i++) {
				System.out.print(myChange[i] + " ");
			}
		}
	}

	
	public static int[] change(int amount, int[] denom) {
		int[] c = new int[denom.length];
		
		for(int i = 0; i < denom.length; i++) {
			while(amount >= denom[i]){
				amount -=  denom[i];
				++c[i];
			}
		}

		if(amount > 0)
			return null;

		return c;
	}
}
