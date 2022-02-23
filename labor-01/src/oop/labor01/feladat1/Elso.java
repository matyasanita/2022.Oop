package oop.labor01.feladat1;

import java.sql.Array;
import java.util.*;
import java.math.*;
import java.util.Random;

public class Elso {
    public static void main(String[] args) {

//        nevKiir("Gazos Geza");
//        monogramKiir("Gazos Geza");
//        piramisKiir();
//        System.out.println(getBit(4,1));
//        System.out.println(countBits(9));
//        double[] array = {2.0,3.0,4.0,5.0,7.5,7.6,3};
//        System.out.println(mean(array));
//        double[] max = max2(array);
//        System.out.println(max[0] + " " + max[1]);

    }

    public static void nevKiir(String nev){
        for (int i = 0; i < nev.length(); i++) {
            System.out.println(nev.charAt(i));

        }
        System.out.println("\n");
    }

    public static void monogramKiir(String nev){
        String monogramArray[] = nev.split(" ");
        String monogram="";
        for (int i = 0; i < monogramArray.length; i++) {
            //System.out.println(monogramArray[i].charAt(0));
            monogram = monogram + monogramArray[i].charAt(0);
        }
        System.out.println("Monogram = " + monogram);
    }

    public static void piramisKiir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Olvass be egy szot!");
        String piramis = sc.nextLine();

        //System.out.println(piramis);

        String seged="";
        for(int i = 0; i<piramis.length(); i++){
            System.out.println(seged+piramis.charAt(i));
            seged += piramis.charAt(i);
        }
    }

    //Készítsen statikus függvényt, amely visszatéríti egy egész szám adott sorszámú bitjének az értékét.
    //A biteket jobbról balra, nullától kezdődően sorszámozzuk.

    public static int getBit(int n,int i){
        if(i<0) return -1;
        else{
            while(i>0){
                n=n>>2;
                i--;
            }
            return n&1;
        }
    }

    public static int countBits(int n){
        int count=0;
        while(n!=0){
            int res=n&1;
            n=n>>2;
            count+=res;
        }
        return count;
    }

//    Készítsen statikus függvényt, amely meghatározza egy valós számokból álló tömb átlagát. Üres
//    tömb esetén térítse vissza a Double.NaN-t.
//    Hívja meg a függvényt a main metódusból, ellenőrizze ennek helyességét.

    public static double mean(double array[]){
        if(array.length == 0) return Double.NaN;

        double meanArray = 0;
        for(int i=0; i<array.length; i++){
            meanArray += array[i];
        }

        if(meanArray==0) return 0;

        meanArray = meanArray / array.length;
        return meanArray;
    }

    //Készítsen statikus függvényt, amely meghatározza egy valós számokból álló tömb szórását
    //(standard deviation). Üres tömb esetén térítse vissza a Double.NaN-t

    public static double sttdev(double array[]){

        if(array.length == 0) return Double.NaN;

        double meanOfArray = mean(array);
        double sd;

        double res=0;
        for(int i=0; i<array.length;i++){
            res= res + Math.pow((Math.abs(array[i] - meanOfArray)),2);
        }
        sd = res / array.length;
        sd = Math.sqrt(sd);
        return sd;
    }

    //6.FELADAT
    public static double[] max2( double array[] ){
        double max[] ={Double.NEGATIVE_INFINITY,
                Double.NEGATIVE_INFINITY};
        if( array.length == 0 ){
            max[0] = Double.NaN;
            max[1] = Double.NaN;
            return max;
        }
        if( array.length == 1 ){
            max[0] = array[0];
            max[1] = array[0];
            return max;
        }

        for( int i=0; i<array.length; i++ ){
            if(array[i] > max[1]){
                if(array[i] > max[0]){
                    max[1] = max[0];
                    max[0] = array[i];
                }
                else{
                    max[1] = array[i];
                }
            }
        }
        return max;
    }

}
