package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary{

    private ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance = null;

    private ArrayListDictionary(){
        try {
            Scanner sc = new Scanner(new File(DICTIONARY_FILE));
            while (sc.hasNextLine()){
                String word = sc.nextLine();
                words.add(word);
                //System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static IDictionary newInstance(){
        if (instance == null)
            instance = new ArrayListDictionary();
        return instance;
    }

    @Override
    public boolean add(String word) {
        try{
            words.add(word);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean find(String word) {
        if (Collections.binarySearch(words,word) >= 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return words.size();
    }
}
