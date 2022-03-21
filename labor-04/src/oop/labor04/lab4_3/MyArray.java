package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private static int length;
    private static double[] elements;

    public MyArray(int length){
        this.length = length;

    }
    //public MyArray(MyArray) //itt at kell masolni kezzel, nem memoriacimet adok at
    public MyArray(double[] elements){
        for(double obj : elements){
            this.elements[length] = obj;
            length++;
        }
    }

    public MyArray(MyArray array){
        this.length = array.getLength();
        int i= 0;
        for(double obj : array.getElements()){
            this.elements[i] = obj;
            i++;
        }
    }

    public MyArray (File fileName){
        try {
            Scanner sc = new Scanner(new File(String.valueOf(fileName)));
            length = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] arrayElements = line.split(" ");
            int index = 0;
            for (String obj : arrayElements){
                elements[index] = Integer.parseInt(obj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //getters
    public static double[] getElements() {
        return elements;
    }

    public static int getLength() {
        return length;
    }

    //other methods
    public void fillRandom(double a, double b){
        for(int i=0; i<length; i++){
            Random rand = new Random();
            elements[i] = rand.nextDouble((b-a) + 1);
        }
    }
}
