package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.pow;

public class MyArray {
    private int length;
    private double[] elements;

    public MyArray(int length){
        this.length = length;
        elements = new double[length];

    }
    //public MyArray(MyArray) //itt at kell masolni kezzel, nem memoriacimet adok at
    public MyArray(double[] array){
        this.length = array.length;
        this.elements = new double[length];

        int i =0;

        for( double e : array ){
            this.elements[i] = e;
            i++;
        }
    }

    public MyArray(MyArray array){
        this.length = array.getLength();
        this.elements = new double[length];

        int i= 0;
        for(double e : array.getElements()){
            this.elements[i] = e;
            i++;
        }
    }

    public MyArray (String fileName){
        try {
            Scanner sc = new Scanner(new File(fileName));
            this.length = Integer.parseInt(sc.nextLine());
            this.elements = new double[length];

            String line = sc.nextLine();
            String[] arrayElements = line.split(" ");
            int index = 0;
            for (String s : arrayElements){
                this.elements[index] = Integer.parseInt(s);
                index ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //getters
    public double[] getElements() {
        return elements;
    }

    public int getLength() {
        return length;
    }

    //other methods
    public void fillRandom(double a, double b){
        for(int i=0; i<length; i++){
            Random rand = new Random();
            elements[i] = rand.nextDouble((a) + b-a);
        }
    }

    public double mean(){
        double m = 0.0;

        for (double e : elements) {
            m += e;
        }

        return m/length;
    }

    public double stddev(){
        double m = this.mean();
        double standDev = 0.0;

        for( double num : elements ){
            standDev += pow((num - m), 2);
        }

        double res = standDev / length;
        res = Math.sqrt(res);
        return res;
    }

    public void sort(){
        Arrays.sort(elements);
    }

    public void print(String s){
        String res = Arrays.toString(elements);
        res = res.replace("["," ");
        res = res.replace("]"," ");
        System.out.println(s +": " + res);
    }
}
