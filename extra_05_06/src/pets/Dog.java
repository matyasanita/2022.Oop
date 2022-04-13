package pets;

import date.MyDate;
import interfaces.IPatient;
import utils.Enums.DogBreed;
import utils.Enums.PetType;
import utils.Enums.Seriosity;
import utils.Util;


public class Dog extends Pet {

    public DogBreed dogBreed;
    public PetType patientType;
    public boolean goodHouseKeeper;
    public Seriosity seriosityOfCase;

    public String speak(){
        return "Wuff wuff";
    }

    public Dog(boolean goodHouseKeeper, MyDate birthDate, String petName, double currentWeight) {
        super(birthDate, petName, currentWeight);
        this.dogBreed = dogBreed;
        this.patientType = patientType;
        this.goodHouseKeeper = goodHouseKeeper;
        DogBreed[] randBreed = DogBreed.values();
        this.dogBreed = randBreed[Util.random.nextInt(randBreed.length)];
    }

    //getters


    public DogBreed getDogBreed() {
        return dogBreed;
    }

    public PetType getPatientType() {
        return patientType;
    }

    public boolean isGoodHouseKeeper() {
        return goodHouseKeeper;
    }

    public Seriosity getSeriosityOfCase() {
        return seriosityOfCase;
    }

    @Override
    public String toString() {
        String res;
        res = "a "+ this.dogBreed + " dog, named " + this.petName + " born in: "
        + this.birthDate;
        return res;
    }
}
