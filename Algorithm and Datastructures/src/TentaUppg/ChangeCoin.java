/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

import java.util.Arrays;

/**
 *
 * @author Returnerar antal mynt för att lösa problemet, inte vilka mynt
 */
public class ChangeCoin {
    
    public static void main(String[] args) {
		int[] values = {100, 11, 10, 1};
		System.out.println(change(values,130));

	}

	private static int change(int[] values, int amount) {
		int[] nrChange = new int[amount+1];//varje plats kommer att innehålla antal växel för indexets belopp
		int[] nrChangeTmp = new int[amount+1];
		for(int i=0;i<values.length;i++)
			nrChange[values[i]]=1;
		while(nrChange[amount]==0){
			nrChangeTmp=Arrays.copyOf(nrChange,nrChange.length);
			for(int i=1;i<nrChange.length;i++){
				if(nrChangeTmp[i]!=0){
					for(int j=0;j<values.length;j++){
						if(i+values[j]<nrChange.length){
							if(nrChange[i+values[j]]==0){
								nrChange[i+values[j]]=nrChange[i]+1;
							}
						}
					}
				}
			}
			//System.out.println(Arrays.toString(nrChange));
		}
		return nrChange[amount];
		
	}
}
