package interfaces;

import utils.Enums.PetType;
import utils.Enums.Seriosity;

import java.util.ArrayList;

public interface IPatient {
    public PetType patientType;
    public ArrayList<String> diseases;
    public Seriosity seriosityOfCase;
}
