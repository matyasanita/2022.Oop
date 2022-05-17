package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService{
    private IDictionary dictionary = null;

    public DictionaryService(DictionaryType dtype){
        dictionary = DictionaryProvider.createDictionary(dtype);
    }

    public boolean findWord(String word){
        if (dictionary.find(word))
            return true;
        return false;
    }

    public ArrayList<String> findWordsFile(String file){
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(file));
            while(sc.hasNextLine()){
                String word = sc.nextLine();
                if (! dictionary.find(word))
                    words.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

}
