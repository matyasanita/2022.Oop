package Hasznos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Hasznos {
    private static TreeMap<Integer, String> countyCodes = new TreeMap<Integer,String>();
    private static final String input = "megyekodok.txt";

    public static void olvasMegyekodok(){
        try {
            Scanner sc = new Scanner(new File(input));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                try{
                    String[] items = line.split("\t");
                    int id = Integer.parseInt(items[1].strip());
                    String county = items[0].strip();
                    countyCodes.put(id,county);
                }
                catch (NumberFormatException numberFormatException){
                    System.out.println("Number format exception: "+line);
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Incomplete line:" + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void kiirMegyekodok(){
        System.out.println("County codes: ");
        for(Map.Entry<Integer,String> entry: countyCodes.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static String getMegye(int kod){
        return countyCodes.get(kod);
    }

}
