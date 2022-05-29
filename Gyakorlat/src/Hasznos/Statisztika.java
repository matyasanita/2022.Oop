package Hasznos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statisztika {
    private ArrayList<SzemelyiSzam> szemelyek = new ArrayList<>();
    public Statisztika(String fileName){
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                try{
                    String[] items = line.split(" ");
                    String id = items[0].strip();
                    szemelyek.add(new SzemelyiSzam(id));
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Incomplete lineL:" + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void listazas(){
        System.out.println("Szemelyek: ");
        szemelyek.forEach(System.out::println);
    }
    public void rendezMegyekSzuletesiEvek(){
        Collections.sort(szemelyek);
    }
    public void printMegyekSzemelyekSzama(){
        HashMap<String, Integer> statisztikaMap = new HashMap<>();
        for (SzemelyiSzam szemely : szemelyek){
            String megye = szemely.getMegye();
            if (statisztikaMap.containsKey(megye)){
                statisztikaMap.put(megye,statisztikaMap.get(megye) + 1);
            }
            else{
                statisztikaMap.put(megye,1);
            }
        }

        for (Map.Entry<String,Integer> entry : statisztikaMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
