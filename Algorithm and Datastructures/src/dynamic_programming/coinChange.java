/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * @author yasin93
 */
public class coinChange {
    static int[] mynt={100,50,20,10,5,1};
   
    public static int changeNonDynamic(int belopp){
        int v;
        for(int i=0;i<mynt.length-1;i++){
            if(mynt[i]==belopp)
                return 1;
        }
        v=belopp;
        for(int i=1;i<=belopp/2;i++)
            v=Math.min(v, changeNonDynamic(i)+changeNonDynamic(belopp-i));
        return v;
    }
    ///Bottom-up coin change
    public static int changeDynamic(int amount,int[] d){
      int[] C=new int[amount+1];
       C[0]=0;
       
     for(int j = 1; j <= amount; j++) {
	C[j] = Integer.MAX_VALUE;
	for(int i = 0; i < d.length; i++) {
	    if(j >= d[i] && 1 + C[j-d[i]] < C[j] ) {
		C[j] = 1 + C[j-d[i]];
	    }
        }
    }     
    return C[amount];
    }    
    

    
    public static void main(String[] args){
        int[] mynt={100,50,20,10,5,1};
        System.out.println(changeDynamic(500,mynt));
      
        
        }
    }

