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
public class plattSattare {
    
    public static void main(String[] args) {
		System.out.println(numberConfig(3));

	}

	private static int numberConfig(int length) {
		if(length==1) return 1;
		if(length==2) return 2;
		if(length==3) return 4;
		return numberConfig(length-1)+numberConfig(length-2)+numberConfig(length-3);
	}
}
