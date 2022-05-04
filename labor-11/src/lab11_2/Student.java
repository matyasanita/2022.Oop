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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "neptunCode='" + neptunCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credits=" + credits +
                ", birthDate=" + birthDate +
                '}';
    }
}
