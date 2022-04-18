package utils;

import utils.Enums.PetType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util {
    public class Disease {
        private final static ArrayList<String> treatments = new ArrayList<String>();
        private PetType petType;
        private String disease;

        public Disease(PetType petType, String disease) {
            this.petType = petType;
            this.disease = disease;
        }

        public void addTreatments(List<String> treatments) {
            for (String t : treatments) {
                this.treatments.add(t);
            }
        }

        public PetType getPetType() {
            return petType;
        }

        public String getDisease() {
            return disease;
        }


    }

    public static Random random;
    public static ArrayList<String> commonWords;
    public static ArrayList<Disease> diseases;

    public static ArrayList<Disease> getDiseasesByPetType(PetType petType) {
        ArrayList<Disease> res = new ArrayList<>();
        for (Disease d : diseases){
            if (d.getPetType() == petType){
                res.add(d);
            }
        }
        return res;
    }

    public static int getNumOfDiseasesByPet(PetType petType) {
        return getDiseasesByPetType(petType).size();
    }






    public void readDiseasesAndTreatmentsFromFile(String file) {
        try {
            Scanner sc = new Scanner(new File("file"));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(",");
                Disease d = new Disease(PetType.valueOf(elements[0]), elements[1]);

                List<String> treatments = new ArrayList<String>();
                for (int i = 2; i < elements.length; i++) {
                    treatments.add(elements[i]);
                }

                d.addTreatments(treatments);
                diseases.add(d);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
