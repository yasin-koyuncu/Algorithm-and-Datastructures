/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divide_and_conquer;

/**
 *
 * @author yasin93
 */
public class MaxPartSequenceValue {
    
    
    public static void main(String[] args){
        int[] a={5,-5,3,-3,2,3,21,80,-12,32,1,8,-3,-6};
        int max=maxSum(a,0,13);///Med söndra o härska
        
        System.out.print(max);
        
    }
    //Söndra och härska
    public static int maxSum(int[] a,int left,int right){
        if(left>right)
            return 0;
        if(left==right)
            return Math.max(0, a[left]);
        
        int center=(left+right)/2;
        int sum=0,maxLeft=0;
        
        for(int i=center;i>=left;i--){
            sum+=a[i];
            maxLeft=Math.max(maxLeft, sum);
            
        }
        sum=0;int maxRight=0;
        for(int i=center+1;i<right;i++){
            sum+=a[i];
            maxRight=Math.max(maxRight, sum);
            
        }
        int maxOverMitt=maxLeft+maxRight;
        
        return Math.max(maxOverMitt, Math.max(maxSum(a,left,center), maxSum(a,center+1,right)));
    }
    
    //Utan söndra o härska
    
    public static int maxSum2(int[] a){
        int maxSumma=0,maxLokal=0;
        
        for(int i=0;i<a.length-1;i++){
            maxLokal=Math.max(maxLokal+a[i], 0);
            maxSumma=Math.max(maxLokal, maxSumma);
            
        }
        return maxSumma;
        
    }
}
