/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy_algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author yasin93
 */
public class MapCountry {
    
   public static void main(String[] args) {
		map();

	}

	
	public static void map(){
		int countries=0,borders=0;
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\yasin93\\Desktop\\Dator Info\\workspace\\AlgoritmPlugg\\src\\F11\\karta.txt"));
			countries = Integer.parseInt(in.readLine());
			borders = Integer.parseInt(in.readLine());
			int [] country = new int[countries];
			boolean [] colors = new boolean[countries];
			boolean[][] border = new boolean[borders][borders];
			for(int i = 0; i < countries; i++) {
				country[i] = 0;
			}
			
			while (true) {
			    final String s = in.readLine();
			    if (s == null) 
			    	break;
			    for(int i = 0; i < border.length; i++) {	
					for(int j = 0; j < border.length; j++){
						if( Character.getNumericValue(s.charAt(0)) == i && Character.getNumericValue(s.charAt(2)) == j){
							border[i][j] = true;
							border[j][i] = true;
							System.out.println(i + " " + j);
						}
					}
				}
			}
			//går igenom länderna så att vi hanterar land i nedan
			for(int i = 0; i < country.length-1; i++) {
				int cLength = 0;
				for(int k = 0; k < country.length; k++) {
					if(country[k] == 0) {
						int cTmpLength = 0;
						for(int j = 0; j < country.length; j++) {
							if(border[k][j] || border[j][k] && country[j] != 0) {
								++cTmpLength;
							}
						}
						cLength = cTmpLength;
					}
				}
				Arrays.fill(colors, false);//Sätt färg[j]= false för alla 
				setArrayToFalse(colors);
				for(int j = 0; j < country.length-1; j++) {//går igenom länderna för att hitta grannar till land i
					if(border[j][i] || border[i][j] && country[j] != 0) {
						colors[country[j]] = true;//markerar angränsande färger
					}
				}
				
				for(int j = 1; j < colors.length; j++) {//går igenom färgerna för att hitta första lediga
					if(!colors[j]){
						country[i] = j;
						break;
					}	
				}
			}
			
			for(int i = 0; i < country.length; i++) {
				System.out.println("Land " + i + " Färg " + country[i]);
			}

			
			
			in.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	public static boolean[] setArrayToFalse(boolean [] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = false;
		}
		return array;
	}
}
