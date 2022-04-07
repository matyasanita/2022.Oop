package oop.labor08.ex1;

import java.util.ArrayList;

public class Customer {
    //constants
    public static final int MAX_ACCOUNTS = 10;
    private final int id;

    //private members
    private final String firstName;
    private String lastName;
    private static int numCustomers;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    //contructor

    public Customer(String firstName, String lastName){
        numCustomers++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = numCustomers;
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

    public int getId() {
        return id;
    }

    public static int getNumCustomers() {
        return numCustomers;
    }

    public BankAccount getAccounts(int nr) {
        if (nr < getAccountNr())
            return accounts.get(nr);
        else System.out.println("The account does not exist.");
        return null;
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

    public int getNumAccounts() {
        return accounts.size();
    }
}
