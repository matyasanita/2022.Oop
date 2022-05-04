package lab11_1;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adj meg samokat szokozzel elvalasztva:");
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String items[] = line.split(" ");
        double sum = 0;
        for (String s : items){
            try{
                sum += Double.parseDouble(s);
            }
            catch(NumberFormatException numberFormatException){
                System.out.println(s + " is not a double");
                continue;
            }

        }
        System.out.println("The sum is:" + sum);

    }
}
