package oop.labor02.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("UC123");
        account1.deposit(500);
        boolean res = account1.withdraw(600);
        if (!res) System.out.println("You do not have sufficient funds for this operation!");

        System.out.println(account1.getBalance());
        System.out.println(account1.toString());
    }
}
