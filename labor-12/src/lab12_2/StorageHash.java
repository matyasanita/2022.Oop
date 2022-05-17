package lab12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StorageHash {
    private String fileName;
    private HashMap<Integer, Product> products = new HashMap<>();

    public StorageHash(String fileName) {
        this.fileName = fileName;

        try(Scanner sc = new Scanner(new File(fileName))){
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();

                if (line.isEmpty())
                    continue;

                String[] elements = line.split(" ");
                int ID = Integer.parseInt(elements[0]);
                String name = elements[1];
                int amount = Integer.parseInt(elements[2]);
                int price = Integer.parseInt(elements[3]);

                products.put(ID,new Product(ID,name,amount,price));

            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void update(String fileName){

        int updatedNr = 0;

        try(Scanner sc = new Scanner(new File(fileName))){
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();

                if (line.isEmpty())
                    continue;

                String[] elements = line.split(" ");
                int ID = Integer.parseInt(elements[0]);
                int amount = Integer.parseInt(elements[1]);

                if(products.containsKey(ID)) {
                    products.get(ID).increaseAmount(amount);
                    updatedNr ++;
                }

            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        //print the number of products updated
        System.out.println("Number of products updated: " + updatedNr);

    }

    @Override
    public String toString() {
        String res="";
        res += "Storage:\n";
        for (Map.Entry<Integer, Product> entry : products.entrySet()){
            res += entry.getValue().toString() + "\n";
        }
        return res;
    }

}

