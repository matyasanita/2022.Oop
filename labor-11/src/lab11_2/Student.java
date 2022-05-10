package lab11_2;

public class Student {
    private final String neptunCode;
    private final String firstName;
    private String lastName;
    private int credits;
    private final MyDate birthDate;

    //constuctor

    public Student(String neptunCode, String firstName, String lastName, int credits, int year, int month, int day) throws InvalidDateException{
        this.birthDate = new MyDate(year,month,day);
        this.neptunCode = neptunCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
    }

    //getters

    public int getCredits() {
        return credits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return neptunCode + "," + firstName + "," + lastName + "," + credits + "," + birthDate + "\n";
    }
}
