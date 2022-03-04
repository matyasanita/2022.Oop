package oop.labor03.ex2;

public class Main {
    public static void main(String[] args) {
        Customer julis = new Customer("Julis", "Nagy");
        Customer geza = new Customer("Geza", "Gazos");

        String accNumEx = "OTP0000";
        int sum = 500;
        for(int i=0; i<5 ; i++){
            julis.addAccount(new BankAccount(accNumEx + i));
            julis.getAccount(accNumEx + i).deposit(sum + i * 100);
        }

        accNumEx = "OTP1000";
        for(int i=0; i<9 ; i++){
            geza.addAccount(new BankAccount(accNumEx + i));
            geza.getAccount(accNumEx + i).deposit(sum + i * 100);
        }

        System.out.println(julis);
        System.out.println(geza);


        julis.closeAccount("OTP00000");
        geza.closeAccount("OTP10008");


        System.out.println(julis);
        System.out.println(geza);

    }
}
