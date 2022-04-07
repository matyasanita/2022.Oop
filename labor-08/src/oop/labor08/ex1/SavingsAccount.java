package oop.labor08.ex1;

public class SavingsAccount extends BankAccount{
    private double interestRate ;

    public SavingsAccount(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(){
        super.balance += super.balance * interestRate;
    }

    @Override
    public String toString() {
        return  "-Savings Account:\n" +
                "\taccountNumber=" + accountNumber + "\n" +
                "\tbalance=" + balance + "\n" +
                "\tinterestRate=" + interestRate + "\n";
    }
}
