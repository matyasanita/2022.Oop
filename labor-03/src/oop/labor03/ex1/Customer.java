package oop.labor03.ex1;

public class Customer {
    private String firstName;
    private String lastName;
    private BankAccount account;

    //contructor

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters

    public BankAccount getAccount(){
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //setters

    public void setAccount(BankAccount account){
        this.account = account;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(){
        account = null;
    }

    @Override public String toString(){
        String res = "First name: " + firstName + "\nLast name: " + lastName + "\n";
        if (account == null)
            res += "Account: No account\n";
        else
            res += account.getAccountNumber() + "\n";

        return res;
    }

}
