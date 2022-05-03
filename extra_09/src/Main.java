import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
        Aramkor ar1 = new Aramkor();
        ar1.add(new Ellenallas(34.12,45.3));
        ar1.add(new Ellenallas(34.12,654.3));
        ar1.add(new Kondenzator(89.8,34.2));
        ar1.add(new Kondenzator(89.8,3254.1));
        ar1.add(new Tranzisztor(89.8,"32423"));
        ar1.add(new Tranzisztor(89.8,"36345"));

        System.out.println(ar1);
        System.out.println("Overall price: " + ar1.getOverallPrice());

        //Kondenzatorok torlese
        ar1.delete(89.8,34.2,"");
        ar1.delete(89.8,3254.1,"");
        System.out.println(ar1);
        System.out.println("Overall price: " + ar1.getOverallPrice());

        //Alkatresze most az egyik torolt kondenzator?
        System.out.println(ar1.searchForPart(ar1.getPart(89.8,3254.1,"")));

        //Csak ellenallasokbol all?
        System.out.println(ar1.csakEllenallasok());

        //Kitoroljuk a ket tranzisztort
        ar1.delete(89.8,0.0,"32423");
        ar1.delete(89.8,0.0,"36345");
        System.out.println(ar1);

        //Csak ellenallasokbol all?
        System.out.println(ar1.csakEllenallasok());

        //Kiszamoljuk az eredo ellenallast
        System.out.println("Eredo ellenallas: " + ar1.eredoEllenallas());

        //Beolvasunk egy uj aramkort az aramkor.txt-bol
        Aramkor ar2 = new Aramkor("aramkor.txt");
        System.out.println("\n" + ar2);

    }
}
