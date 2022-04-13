package pets;

import date.MyDate;
import interfaces.IPatient;
import utils.Enums.PetType;
import utils.Enums.Taxonomy;
import utils.Util;

import java.util.ArrayList;

public abstract class Pet implements IPatient {

    public static int numPets = 0;
    protected ArrayList<String> diseases = new ArrayList<>();

    int petId;
    Taxonomy taxonomy;
    boolean healthy;
    final MyDate birthDate;
    final String petName;
    double currentWeight;

    //constructor

    public Pet (MyDate birthDate, String petName, double currentWeight){
        numPets ++;
        this.petId = numPets;
        this.birthDate = birthDate;
        this.petName = petName;
        this.currentWeight = currentWeight;
        healthy = true;
    }

    //methods
    public abstract String speak();
    public void unexpectedIllnessOccured(){
        int randomIllness = Util.random.nextInt(Util.getNumOfDiseasesByPet(PetType.Dog))-1);
        this.diseases.add(Util.getDiseasesByPetType(PetType.Dog)).get(randomIllness).getDisease());
    }

    public void checkHealthStatus(){
        if ( healthy == true ){
            System.out.println(petName + " is healthy");
        }
        else{
            System.out.println(petName + " is suffering from the following diseases:\n");
            for (String s : diseases){
                System.out.println("\t-" + s);
            }
        }
    }

    public void healing(){
        while(! diseases.isEmpty()){
            diseases.remove(0);
        }
        healthy = true;
    }

    public static int getNumPets(){
        return numPets;
    }

    //getters

    protected String getDiseases() {
       if ( healthy == false ){
           return diseases.get(diseases.size() - 1);
       }
       System.out.println("The pet is healthy!");
       return "-1";
    }

    protected int getPetId() {
        return petId;
    }

    protected Taxonomy getTaxonomy() {
        return taxonomy;
    }

    protected boolean isHealthy() {
        return healthy;
    }

    protected MyDate getBirthDate() {
        return birthDate;
    }

    protected String getPetName() {
        return petName;
    }

    protected double getCurrentWeight() {
        return currentWeight;
    }


}
