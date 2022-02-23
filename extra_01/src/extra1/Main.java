package extra1;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        randomArray();
    }

    public static void randomArray(){
        int arraySize = 1000000;
        int array[] = new int [arraySize];
        Random rand = new Random();
        int upperbound = 1000000;

        for(int i=0 ; i<arraySize ; i++){
            int random = rand.nextInt(upperbound);
            array[i] = random;
            //System.out.println(array[i]);
        }

        int duplicates = 0;

        Arrays.sort(array);
        int i=0;
        while(i < arraySize-3){
            int nrOnIndex = array[i];
            if (array[i] == array[i+1] && array[i+1] != array[i+2])
                duplicates++;
            if (array[i] == array[i+1] && array[i+1] == array[i+2]){
                while(array[i] == nrOnIndex && i< arraySize-3){
                    i++;
                }
            }
            else{
                i++;
            }
        }
        System.out.println("Number of duplicates: " + duplicates);
    }
}

