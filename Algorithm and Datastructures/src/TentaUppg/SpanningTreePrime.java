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
public class SpanningTreePrime {
    
    public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = {	
						{	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 3, 1, X, X},
						{	X, 4, 3, 3, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};
		int[][] w2 = {	
				{	X, 3, 4, 5, 6},
				{	3, X, 6, 5, 6},
				{	4, 6, X, 3, 4},
				{	5, 5, 3, X, 2},
				{	6, 6, 4, 2, X}};
		System.out.println(prim(w));
	}

	private static int prim(int[][] w) {
		boolean[] spanningTree = new boolean[w[0].length];
		for(int i=0;i<spanningTree.length;i++)
			spanningTree[i]=false;
		int totalWeight = 0;
		spanningTree[0]=true;
		for(int i=1;i<spanningTree.length;i++){
			int nextToConnect=-1;
			int nextWeight=Integer.MAX_VALUE;
			for(int connectTo=0;connectTo<spanningTree.length;connectTo++){
				if(spanningTree[connectTo]){
					for(int connect=0;connect<spanningTree.length;connect++){
						if(!spanningTree[connect]){
							if(w[connect][connectTo]<nextWeight){
								nextWeight=w[connect][connectTo];
								nextToConnect=connect;
							}
						}
					}
				}
			}
			spanningTree[nextToConnect]=true;
			totalWeight+=nextWeight;
		}
		return totalWeight;
	}
}
