package oop.labor02.date;

import java.util.Random;


public class Main {
    public static void main(String[] args) {

        int year, month, day;
        int invalidDates = 0;
        Random rand = new Random();

        for(int i=0 ; i<1000; i++){
            year = 1 + rand.nextInt(2022);
            month = 1 + rand.nextInt(12);
            day = 1 + rand.nextInt(31);

            MyDate d = new MyDate(year, month, day);

            if (DateUtil.isValidDate(year,month,day))
                System.out.println(d);
            else invalidDates ++;

        }

        System.out.println("Invalid dates: " + invalidDates);


//        System.out.println(DateUtil.isValidDate(2000,2,29) == true);
//        System.out.println(DateUtil.isValidDate(2000,2, 30) == false);
//        System.out.println(DateUtil.isValidDate(1900,2, 29) == false);
//        System.out.println(DateUtil.isValidDate(1900,2, 28) == true);
//        System.out.println(DateUtil.isValidDate(-1900,2, 28) == false);
//        System.out.println(DateUtil.isValidDate(0,2, 28) == false);
//        System.out.println(DateUtil.isValidDate(2021,2, 29) == false);
//        System.out.println(DateUtil.isValidDate(2020,2, 29) == true);
//        System.out.println(DateUtil.isValidDate(2020,1, 32) == false);
//        System.out.println(DateUtil.isValidDate(2020,1, 0) == false);
//        System.out.println(DateUtil.isValidDate(2020,0, 0) == false);
//        System.out.println(DateUtil.isValidDate(2020,4, 31) == false);
//        System.out.println(DateUtil.isValidDate(2020,1, 31) == true);

    }
}
