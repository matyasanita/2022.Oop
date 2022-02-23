package extra2;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        binarySearchTime();
    }

    public static int myBinarySearch(int number, int[] array){

        int l = 0, r = array.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (array[m] == number)
                return m;

            if (array[m] < number)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }

    public static void binarySearchTime(){
        int arraySize = 1000000;
        int array[] = new int [arraySize];
        Random rand = new Random();
        int upperbound = 100000;

        for(int i=0 ; i<arraySize ; i++){
            int random = rand.nextInt(upperbound);
            array[i] = random;
            //System.out.println(array[i]);
        }
        Arrays.sort(array);

        int key = 6000;

        long startTime = System.nanoTime();
        int a = myBinarySearch(key, array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Index: " + a);
        System.out.println("Duration of myBinarySearch: "+ duration);


        startTime = System.nanoTime();
        a = Arrays.binarySearch(array, key);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Index: " + a);
        System.out.println("Duration of binarySearch: "+ duration);
    }

}
