package oop.labor08.ex1;

public class BankAccount {

    //Attributumok
    protected final String accountNumber;
    protected double balance;
    public static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;

    protected BankAccount(){
        ++numAccounts;
        this.accountNumber = createAccountNumber();
    }

    private String createAccountNumber(){
        String acc = PREFIX;
        int db = ACCOUNT_NUMBER_LENGTH - PREFIX.length() - String.valueOf(numAccounts).length();
        acc += "0".repeat(db);
        acc += numAccounts;
        return acc;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getNumAccounts() {
        return numAccounts;
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
