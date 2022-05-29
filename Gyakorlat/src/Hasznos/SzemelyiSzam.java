package Hasznos;

public class SzemelyiSzam implements Comparable<SzemelyiSzam>{
    private final String cnp;

    public SzemelyiSzam(String cnp) {
        this.cnp = cnp;
    }

    public boolean ferfi(){
        return cnp.charAt(0) == '1';
    }

    public String getCNP(){
        return cnp;
    }

    public int getSzuletesiEv(){
        return Integer.parseInt(cnp.substring(1,3));
    }

    public String getSzuletesiHonapStr(){
        return String.valueOf(Honap.values()[Integer.parseInt(cnp.substring(3,5))-1]);
    }

    public int getSzuletesiHonap(){
        return Integer.parseInt(String.valueOf(cnp.substring(3,5)));
    }

    public int getSzuletesiNap(){
        return Integer.parseInt(String.valueOf(cnp.substring(5,7)));
    }

    public String getMegye(){
        return Hasznos.getMegye(Integer.parseInt(String.valueOf(cnp.substring(7,9))));
    }

    @Override
    public String toString() {
        String res = cnp + ", ";
        if (this.ferfi()) res += "F, ";
        else res += "N, ";
        res += this.getSzuletesiEv() + ", ";
        res += this.getSzuletesiHonapStr() + ", ";
        res += this.getSzuletesiNap() + ", ";
        res += this.getMegye();
        return res;
    }


    @Override
    public int compareTo(SzemelyiSzam o) {
        if (this.getMegye().compareTo(o.getMegye()) != 0){
            return this.getMegye().compareTo(o.getMegye());
        }
        else{
            return this.getSzuletesiEv() - o.getSzuletesiEv();
        }
    }
}
