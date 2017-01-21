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
public class Fibonacci {
    
    public static int fib(int n){
        if(n==1||n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }
    
    ///Dynamisk topdown
    
    public static int fibDynTop(int n){
        int[] tab=new int[100000];
       
        for(int i=0;i<tab.length;i++)
            tab[i]=0;
      
        tab[1]=tab[2]=1;
        
        if(tab[n]!=0) return tab[n];
        return tab[n]=fibDynTop(n-1)+fibDynTop(n-2);
    }
    
    //Dynamisk bottom-up
    
    public static int fibIterativ(int n){
        int fn=0,fnMinus1=1,fnMinus2=1;
        
        for(int i=3;i<=n;i++){
            fn=fnMinus1+fnMinus2;
            fnMinus2=fnMinus1;
            fnMinus1=fn;
        }
        return fn;
            
    }
    public static void main(String[] args){
        System.out.println(fib(8));
        
        System.out.println(fibDynTop(8));
        
        System.out.println(fibIterativ(8));
    }
}
