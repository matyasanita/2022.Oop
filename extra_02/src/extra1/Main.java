package extra1;

import java.io.FileNotFoundException;
import java.util.Random;


enum Color{
    BLUE,
    BLACK,
    RED,
    WHITE,
    GREEN
}

enum FuelType{
    DIESEL,
    HYBRID,
    ELECTRIC,
    PETROL,
    GAS
}


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Car car = new Car("Ford", "Fiesta", 2, true, 2002);
        System.out.println(car);

        String[] input = {"Opel Agila 2008", "Suzuki Vitara 1989", "Ford Focus 2009"};

        Car[] cars = new Car[3];
        int dieselNum = 0;
        int redNum = 0;
        Random rand = new Random();

        for(int i=0; i< input.length; i++){
            String[] res = input[i].split(" ");
            boolean capacity = rand.nextBoolean();
            int fuel = rand.nextInt(4);
            cars [i] = new Car(res[0], res[1], fuel, capacity, Integer.parseInt(res[2]) );
            if(cars[i].getFuelType() == FuelType.DIESEL) dieselNum ++;
            if(cars[i].getColor() == Color.RED) redNum ++;
        }

        System.out.println(cars[0]);
        System.out.println(cars[1]);
        System.out.println(cars[2]);

        boolean firstCar = true;

        for (int i=0; i<=100 ;i++){
            for (int j=0;j<3;j++){
                cars[j].moveCar(rand.nextInt(50) + 1);

                if(cars[j].getSpeed() < 180){
                    cars[j].changeSpeed(10);
                    if (cars[j].getSpeed() >= 180 )
                        System.out.println("Slow down or I'll give you a ticket! *Siren noises*");
                }

                if (cars[j].getNumberOfKilometers() == 0 && firstCar == true){
                    System.out.println("The first car was:" + j);
                    firstCar = false;
                }
            }
        }

        System.out.println("The numeber of diesel cars: " + dieselNum);
        System.out.println("The numeber of red cars: " + redNum);



    }
}
