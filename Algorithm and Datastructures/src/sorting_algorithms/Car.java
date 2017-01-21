/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author yasin93
 */
public class Car /*implements Comparable<Car>*/{

    private String make;
    private String yearModel;

    private int miles;

    public Car(String make, String yearModel, int miles) {
        this.make = make;
        this.yearModel = yearModel;
        this.miles = miles;
    }

    public String getMake() {
        return make;
    }

    public String getYearModel() {
        return yearModel;
    }

    public int getMiles() {
        return miles;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        String str = "", test = "";
        PrintWriter write;
        try {
            write = new PrintWriter("C:\\Users\\yasin93\\Desktop\\Dator Info\\workspace\\AlgoritmPlugg\\src\\F9\\newCar.txt");
            br = new BufferedReader(new FileReader("C:\\Users\\yasin93\\Desktop\\Dator Info\\workspace\\AlgoritmPlugg\\src\\F9\\Bilar.txt"));
            while (true) {
                if ((test = br.readLine()) == null) {
                    break;
                } else {
                    str += test + "\n";
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            br.close();
        }
        //System.out.println(str);
        String[] carObject;
        carObject = str.split("\n");//Splittra rader

        String[] carDetails;
        //ArrayList<Car> cars = new ArrayList<Car>();
        Car[] cars=new Car[carObject.length];
       

        for (int i = 0; i < carObject.length; i++) {
            carDetails = carObject[i].split(" ");  //Splittra space för bilobjekten
           // cars.add(new Car(carDetails[0], carDetails[1], Integer.parseInt(carDetails[2]))); 
            cars[i]=new Car(carDetails[0], carDetails[1], Integer.parseInt(carDetails[2]));///Detta är ingen hårdkodning. Den tar från arrayPlats 0,1,2, eftersom den endast läser tre saker från en bilobjekt
        }

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getMake()+" "+cars[i].getYearModel()+" "+cars[i].getMiles());
        }
        
        //Arrays.sort(cars);
        /***SORT */
        Car tmp;
        for (int i = 0; i < cars.length; i++) {
            for (int j = i+1; j < cars.length; j++) {
                if(cars[j].getMake().compareTo(cars[i].getMake())<0){
                
                    tmp=cars[j];               
                    cars[j]=cars[i];
                    cars[i]=tmp; 
                }
            }
        }
        
        System.out.println("After sort\n\n");
         for(int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getMake()+" "+cars[i].getYearModel()+" "+cars[i].getMiles());
        }
         
         ///De som är kvar är att implementera en compareto metod
      
         /* for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getMake() + " " + cars.get(i).getYearModel() + " " + cars.get(i).getMiles());
        }*/
        /* for(int i=0;i<carObject.length;i++).
             cut=carObject[i].toString().split(" ");*/

        // ArrayList<Car> cars=new ArrayList<Car>();
        /* for(int i=0;i<carObject.length;i++){
             cars.add(new Car(carObject[i].toString().split(" ")))
         }*/
    }

 
   /* public int compareTo(Car c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.make.
    }*/

    

   
   

    

}
