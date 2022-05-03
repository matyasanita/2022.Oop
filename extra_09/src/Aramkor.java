import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aramkor {
    private ArrayList<Alkatresz> parts;

    public Aramkor() {
        parts = new ArrayList<>();
    }

    public Alkatresz getPart(double price, double value, String code){
        for(Alkatresz a : parts){

            if (a.getClass() == Ellenallas.class){
                Ellenallas temp = (Ellenallas) a;
                if (a.getPrice() == price && ((Ellenallas) a).getValue() == value) return a;
            }
            if (a.getClass() == Kondenzator.class){
                if (a.getPrice() == price && ((Kondenzator) a).getValue() == value) return a;
            }
            if (a.getClass() == Tranzisztor.class){
                if (a.getPrice() == price && ((Tranzisztor) a).getCode().equals(code)) return a;
            }
        }
        return null;
    }



    public Aramkor(String fileName) {

        parts = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fileName))){
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                String elements[] = line.split(" ");
                String type = elements[0].trim();
                switch (type){
                    case "Ellenallas":
                        double val = Double.parseDouble(elements[2].trim());
                        double price = Double.parseDouble(elements[1].trim());
                        parts.add(new Ellenallas(price,val));
                        break;
                    case "Kondenzator":
                        val = Double.parseDouble(elements[2].trim());
                        price = Double.parseDouble(elements[1].trim());
                        parts.add(new Ellenallas(price,val));  
                        break;
                    case "Tranzisztor":
                        String code = elements[2].trim();
                        price = Double.parseDouble(elements[1].trim());
                        parts.add(new Tranzisztor(price,code));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + type);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Alkatresz a){
        parts.add(a);
    }

    private boolean containsPart(Alkatresz a){
        if (parts.contains(a)) return true;
        return false;
    }

    public int getPartsNr(){
        return parts.size();
    }

    public double getOverallPrice(){
        double res = 0.0;
        for (Alkatresz alk : parts){
            res += alk.getPrice();
        }
        return res;
    }

    public boolean searchForPart(Alkatresz a){
        return parts.contains(a);
    }


    public void delete(double price, double value, String code){
        Alkatresz a = getPart(price,value,code);
        if (a != null) parts.remove(a);
    }

    boolean csakEllenallasok(){
        for (Alkatresz a: parts){
            if ( a.getClass() != Ellenallas.class ){
                return false;
            }
        }
        return true;
    }

    double eredoEllenallas(){
        if (! csakEllenallasok()) return -1;
        double res = 0.0;

        for (Alkatresz a : parts){
            Ellenallas e = (Ellenallas) a;
            res += e.getValue();
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aramkor that = (Aramkor) o;

        if (that.getPartsNr() == this.getPartsNr()){

            for (Alkatresz a: parts){
                if ( that.searchForPart(a) ){
                    return false;
                }
            }
            return true;
        }
        else return false;

    }

    @Override
    public String toString() {
        String res="";
        for(Alkatresz a: parts){
            res += a.toString() + "\n";
        }
        return res;
    }
}
