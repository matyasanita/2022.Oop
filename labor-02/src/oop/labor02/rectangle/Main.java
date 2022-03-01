package oop.labor02.rectangle;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Rectangle[] rectangles = new Rectangle[10];

        double totalArea = 0 ;

        Random rand = new Random();
        for( int i = 0; i < 10; i++){
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10) ;
            rectangles[ i ] = new Rectangle(length, width);

            System.out.println("Rectangle " + i + "\n" + rectangles[ i ].toString());

            totalArea += rectangles[i].area();
        }

        System.out.println("Total area of the generated rectangles: " + totalArea);

    }
}
