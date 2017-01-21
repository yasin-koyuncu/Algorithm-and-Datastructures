/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_maze_elevator_algorithms;

/**
 *
 * @author yasin93
 */
public class HissAlgoritm {
    
    private static int antalResorHiss(int n,int upp,int ned,int pos,int dest,int antalResor){
        if(pos==dest)
            return antalResor;
        else if(antalResor>30)
            return Integer.MAX_VALUE;
        else{
           int antalUpp=Integer.MAX_VALUE;int antalNed=Integer.MAX_VALUE;
           if(pos+upp<=n)
               antalUpp=antalResorHiss(n,upp,ned,pos+upp,dest,antalResor+1);
           if(pos-ned>=1)
               antalNed=antalResorHiss(n,upp,ned,pos-ned,dest,antalResor+1);
           return Math.min(antalUpp,antalNed);
        }
                  
    }
    
    public static int antalResorHiss(int n,int upp,int ned,int dest){
        return antalResorHiss(n,upp,ned,1,dest,0);
    }
    public static void main(String[] args){
        System.out.println(antalResorHiss(78,15,8,35));
    }
}
