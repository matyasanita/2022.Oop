package oop.labor08.ex1;

public class CheckingAccount extends BankAccount{

    private double overdraftLimit;
    public CheckingAccount(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double amount){

        if (Double.compare(super.balance,amount) >= 0){
            super.balance -= amount;
            return true;
        }
        else {
            double balanceWithOverdraft = super.balance + overdraftLimit;
            if (Double.compare(balanceWithOverdraft,amount) >= 0){
                overdraftLimit = balanceWithOverdraft - balance - amount;
                balance = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "-CheckingAccount\n" +
                "\taccountNumber=" + accountNumber + "\n" +
                "\tbalance=" + balance + "\n" +
                "\toverdraftLimit=" + overdraftLimit + "\n";
    }
}
