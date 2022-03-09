package oop.labor04.lab4_2;

import java.util.ArrayList;

public class Customer {
    //constants
    public static final int MAX_ACCOUNTS = 10;

    //private members
    private String firstName;
    private String lastName;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    //contructor

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters

    public BankAccount getAccount(String accountNumber){

        for( BankAccount obj : accounts ){
            if( obj.getAccountNumber() == accountNumber )
                return obj;
        }

        //if not found
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountNr (){
        return accounts.size();
    }
    //setters

    public void addAccount(BankAccount account){
        if (accounts.size() < MAX_ACCOUNTS){
            accounts.add(account);
        }
        else{
            System.out.println("You have reached the account number limit!\n");
        }
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(String accountNumber){

        boolean closed = false;

        for (BankAccount obj : accounts){
            if ( obj.getAccountNumber() == accountNumber ){
                closed = true;
                accounts.remove(obj);
                System.out.println(accountNumber + " closed\n");
            }
        }

        if (! closed) System.out.println(accountNumber + " not found!\n");
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");

        for (BankAccount obj : accounts ){
            result.append( obj.toString() );
        }
        return result.toString();
    }

}
