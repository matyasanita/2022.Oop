package oop.labor03.ex2;

public class Customer {
    //constants
    public static final int MAX_ACCOUNTS = 10;

    //private members
    private String firstName;
    private String lastName;

    private int numAccounts;
    private BankAccount accounts[] = new BankAccount[ MAX_ACCOUNTS];

    //contructor

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters

    public BankAccount getAccount(String accountNumber){
        for( int i=0; i < numAccounts ; i++){

            String accountOnIndex = accounts[i].getAccountNumber();

            if (accountOnIndex.equals(accountNumber))
                return accounts[i];
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

    public  int getNumAccounts(){
        return numAccounts;
    }

    //setters

    public void addAccount(BankAccount account){
        if (numAccounts < MAX_ACCOUNTS){
            this.numAccounts ++;
            this.accounts[numAccounts-1] = account;
        }
        else{
            System.out.println("You have reached the account number limit!\n");
        }
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(String accountNumber){
        int i ;
        for( i = 0; i < numAccounts ; i++){
            String accountOnIndex = accounts[i].getAccountNumber();
            if (accountOnIndex.equals(accountNumber))
            {
                int j = i;
                while (j + 1 < numAccounts){
                    accounts[j] = accounts[j+1];
                    j++;
                }
                numAccounts --;
                System.out.println(accountOnIndex + " closed\n");
                return;
            }
        }
        if ( i == numAccounts) System.out.println(accountNumber + " does not exist!");

    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for(int i=0; i<numAccounts; ++i){
            result.append( "\t" + accounts[i].toString() +"\n");
        }
        return result.toString();
    }

}
