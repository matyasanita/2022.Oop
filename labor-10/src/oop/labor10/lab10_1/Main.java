package oop.labor10.lab10_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> date = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0 ;i<10;){
            int y,m,d;
            y = 2022;
            m = rand.nextInt(12)+1;
            d = rand.nextInt(31) + 1;
            if (DateUtil.isValidDate(y,m,d)){
                date.add(new MyDate(y,m,d));
                i++;
            }
        }

        for (MyDate d : date){
            System.out.println(d);
        }

        Collections.sort(date);

        System.out.println("After sort:");
        for (MyDate d : date){
            System.out.println(d);
        }
    }
}
