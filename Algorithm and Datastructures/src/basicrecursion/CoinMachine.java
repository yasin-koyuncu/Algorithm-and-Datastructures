/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrecursion;

import java.util.Scanner;

/**
 *
 * @author yasin93
 */
public class CoinMachine {
    
  
	public static void main(String[] args) {
		int result = 0;
		Scanner scan = new Scanner(System.in);
		while(result != -1){
			System.out.println("Ange poäng: ");
			result = scan.nextInt();
			if(result == -1)
				break;
			result = coinMachine(1,result,0);
			if(result < Integer.MAX_VALUE)
				System.out.println("Poängen kan nås med: " + result);
			else
				System.out.println("Poängen kan EJ nås ");
		}
		scan.close();
		System.out.println("Programmet avslutas");
                
                System.out.println(Coin(33));
	}

	
	public static int coinMachine(int points, int pointsToReach, int coins) {
		if(points > pointsToReach){
			System.out.println("MAX VALUE eftersom poängen är " + points); //test
			return Integer.MAX_VALUE;//denna del har ingen lösning, agerar som stopp
		}
		if(points == pointsToReach){
			System.out.println("Träff med " + coins); //test
			return coins;//denna del ger rätt poäng, agerar som stopp 
		}
		System.out.println("Coins: " + coins + " Points: "  + points); //test
		return Integer.min(coinMachine(points*3,pointsToReach,coins+10)
					,coinMachine(points+4,pointsToReach,coins+5)); // returnar den med lägst poäng
	}
        
        //Backtracking
        public static int Coin(int poang){
		//System.out.println(poang);
		
		if(poang == 1)
		   	return 0;

			else if(poang < 1)
		   	return -1;

			else if(poang % 3 == 0 && poang != 9 && poang / 3 != -1)
		   	return Coin(poang / 3) + 10;

			else if(poang - 4 != -1)
		   	return Coin(poang - 4) + 5;

			else
		   	return -1;
	
		
	}

}
