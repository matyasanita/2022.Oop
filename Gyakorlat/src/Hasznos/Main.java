package Hasznos;

public class Main {
    public static void main(String[] args) {
        Hasznos.olvasMegyekodok();
        Hasznos.kiirMegyekodok();

        //Get the county with the code 8:
        System.out.println(Hasznos.getMegye(8));

        System.out.println("----------------------");

        SzemelyiSzam sz = new SzemelyiSzam("6010306142591");
        System.out.println(sz);

        Statisztika st = new Statisztika("cnp.txt");
        st.listazas();
        System.out.println("----------------------");
        st.rendezMegyekSzuletesiEvek();
        st.listazas();
        System.out.println("----------------------");
        st.printMegyekSzemelyekSzama();
    }
}
