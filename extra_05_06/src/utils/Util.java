package utils;

import utils.Enums.PetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public class Disease{
        private final static ArrayList<String> treatments;
        private PetType petType;
        private String disease;

        public Disease(PetType petType, String disease) {
            this.petType = petType;
            this.disease = disease;
        }

        public void addTreatments(List<String> treatment){

        }

        public PetType getPetType() {
            return petType;
        }

        public String getDisease() {
            return disease;
        }

        public static int getNumOfDiseasesByPet(PetType petType) {
            return getDiseasesByPetType(petType).size();
        }

        @Override
        public String toString() {
            return "Disease{" +
                    "petType=" + petType +
                    ", disease='" + disease + '\'' +
                    '}';
        }
    }

    public static Random random;
    public static ArrayList<String> commonWords;
    public static ArrayList<Disease> diseases;

    public void readDiseasesAndTreatmentsFromFile(String file){

    }
}
