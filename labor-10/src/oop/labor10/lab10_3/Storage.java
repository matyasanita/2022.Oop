package oop.labor10.lab10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Storage{
    private String fileName;
    private ArrayList<Product> products = new ArrayList<>();

    public Storage(String fileName) {
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

                products.add(new Product(ID,name,amount,price));

            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        Collections.sort(products);

    }

    private int searchProduct(Product p){
        return Collections.binarySearch(products, p, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getID() - o2.getID();
            }
        });
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

                Product temp = new Product(ID,null,0,0);

                int index = searchProduct(temp);

                if (index >= 0){
                    products.get(index).increaseAmount(amount);
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
        for (Product p : products){
            res += p.toString() + "\n";
        }
        return res;
    }

}

