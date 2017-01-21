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
//Myntväxling med söndra härska
public class ChangeValue {
    ///Fungerar inte

    public static void main(String[] args) {
        int belopp = 551;
        int mynt[] = {100, 50, 1};

       int antal = changeRec(belopp, mynt);
        System.out.println(antal);
        
        //System.out.println(findMinCoins(mynt,belopp));
    }

    public static int findMinCoins(int[] coins, int sum) {
        int[] calculationsCache = new int[sum + 1];
       /* for (int i = 0; i <= sum; i++) {
            calculationsCache[i] = Integer.MAX_VALUE;
        }*/
        calculationsCache[0] = 0;/*sum 0 , can be made with 0 coins*/
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && i - coins[j] >= 0 && calculationsCache[i - coins[j]] + 1 < calculationsCache[i]) {
                    calculationsCache[i] = calculationsCache[i - coins[j]] + 1;
                }
            }
        }
        return calculationsCache[sum];
    }

    public static int changeRec(int belopp, int[] mynt) {
        int minCoin=1000000;
        System.out.println(belopp);
      if(belopp<=0) 
          return minCoin;
      
       
      
      for(int i=0;i<mynt.length;i++){
          if(mynt[i]<=belopp){
              minCoin=Math.min(minCoin,changeRec(belopp-mynt[i],mynt)+1);
          }
          
      }
      return minCoin;
    }
}
