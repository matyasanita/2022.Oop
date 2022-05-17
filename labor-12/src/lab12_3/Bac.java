package lab12_3;

import dictionary.ArrayListDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bac {
    private final Map<Integer, Student> students = new TreeMap<>(); //primitiveket nem adhatunk ,osztalyt kell (Integer)
    private final String studentNamesFile = "nevek1.txt";
    private static Bac instance = null;

    private int passedStudentsCount;
    private int failedStudentsCount;

    private Bac(){
        passedStudentsCount = 0;
        failedStudentsCount = 0;
    }

    public static Bac newInstance(){
        if(instance == null){
            instance = new Bac();
        }
        return instance;
    }

    public int getPassedStudentsCount() {
        return passedStudentsCount;
    }

    public int getFailedStudentsCount() {
        return failedStudentsCount;
    }

    public void assignMarks(){
        for (Classes classType : Classes.values()){
            String fileName = classType + ".txt";
            File file = new File(fileName);
            if (file.exists()){
                try (Scanner sc = new Scanner(file)) {
                    while(sc.hasNextLine()){
                        String line = sc.nextLine();
                        if (line.isEmpty()) continue;
                        String[] items = line.split(" ");
                        int ID = Integer.parseInt(items[0].trim());
                        double mark = Double.parseDouble(items[1].trim());
                        students.get(ID).assignMark(classType,mark);
                    }

                } catch (FileNotFoundException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        //set averages for students
        students.forEach(
                (key,val)->{val.setAverage();
                            if (val.isPassed()) passedStudentsCount ++;
                            else failedStudentsCount ++;
                }
        );
    }

    public void readStudentsFromFile() {
        try (Scanner sc = new Scanner(new File(studentNamesFile))) {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.isEmpty()) continue;
                String[] items = line.split(" ");
                int ID = Integer.parseInt(items[0].trim());
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                students.put(ID,new Student(ID,firstName,lastName));
            }
        }
        catch(FileNotFoundException | NumberFormatException e ){
            e.printStackTrace();
        }
    }

    public void printFailedStudents(){
        students.forEach(
                (key,val)->{
                    if (!val.isPassed())
                        System.out.println(val + "\n");
                }
        );
    }
}
