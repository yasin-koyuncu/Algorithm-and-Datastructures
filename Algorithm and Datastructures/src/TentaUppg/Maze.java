/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yasin93
 */
public class Maze {
    int rows,columns;
	private Position currentP,goal;
	int[][] mazeMatrix;
	
	
	public Maze(){
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\yasin93\\Desktop\\Dator Info\\workspace\\AlgoritmPlugg\\src\\TentaUppg\\Maze.txt"));
			rows = Integer.parseInt(in.readLine())+2;
			columns = Integer.parseInt(in.readLine())+2;
			mazeMatrix = new int[rows][columns];
			for(int j=0;j<columns;j++){
				mazeMatrix[0][j] = 0;
				mazeMatrix[rows-1][j] = 0;
			}
			for(int i=1;i<rows-1;i++){
				mazeMatrix[i][0] = 0;
				mazeMatrix[i][columns-1] = 0;
			}
			for(int i=1;i<rows-1;i++){
				String s = in.readLine();
				for(int j=1;j<columns-1;j++){
					mazeMatrix[i][j]=1;
					if(s.charAt(j-1)=='*')
						mazeMatrix[i][j]=0;
					else if(s.charAt(j-1)=='g'){
						goal = new Position(i,j);
					}
					else if(s.charAt(j-1)=='s'){
						currentP = new Position(i,j);
					}
				}
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	private class Position{
		int row,column;
		public Position(int r, int c){
			row=r;
			column=c;
		}
		
		public boolean equals(Position p){
			return (row==p.row&&column==p.column);
		}
	}
	
	public boolean solve(){
		return solve(currentP);
	}
	private boolean solve(Position p){
		mazeMatrix[p.row][p.column]=2;
		if(p.equals(goal))
			return true;
		else{
			if(mazeMatrix[p.row-1][p.column]==1)//up
				if(solve(new Position(p.row-1,p.column))) return true;
			if(mazeMatrix[p.row][p.column+1]==1)//right
				if(solve(new Position(p.row,p.column+1))) return true;
			if(mazeMatrix[p.row+1][p.column]==1)//down
				if(solve(new Position(p.row+1,p.column))) return true;
			if(mazeMatrix[p.row][p.column-1]==1)//left
				if(solve(new Position(p.row,p.column-1))) return true;
			mazeMatrix[p.row][p.column]=3;
			return false;
		}
	}
	
	public void print(){
		for(int i=1;i<rows-1;i++){
			for(int j=1;j<columns-1;j++)
				System.out.print(mazeMatrix[i][j]);
			System.out.println();
		}
	}
        
        public static void main(String[] args) {
		Maze m = new Maze();
		m.print();
		System.out.println();
		if(m.solve())
			System.out.println("Labyrinten har en utgang");
		else
			System.out.println("Labyrinten saknar utgang");
		System.out.println();
		m.print();

	}
}
