package oop.labor04.lab4_2;

public class BankAccount {

    //Attributumok
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public void deposit(double sum){
        if(sum > 0){
            this.balance = this.balance + sum;
        }
    }

    public boolean withdraw(double x){

        if (this.balance >= x){
            this.balance -= x;
            return true;
        }

        return false;

    }

    @Override
    public String toString(){
        return "\t-Account: " + this.accountNumber + "\tbalance: " + this.balance + "\n";
    }


}