package pets;

import date.MyDate;

public abstract class Pet {
    protected int petId;
    protected final MyDate birthDate;
    protected final String petName;
    protected String diseases;
    protected double currentWeight;
    //protected Taxonomy taxonomy;
    protected boolean healthy;

    public static int numPets;

    public Pet (MyDate birthDate, String petName, double currentWeight){
        this.birthDate = birthDate;
        this.petName = petName;
        this.currentWeight = currentWeight;
    }

}
