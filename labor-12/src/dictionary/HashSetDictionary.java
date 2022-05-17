package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashSetDictionary implements IDictionary{
    private Set<String> words = new HashSet<>();
    private static HashSetDictionary instance = null;

    public HashSetDictionary() {
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
            instance = new HashSetDictionary();
        return instance;
    }

    @Override
    public boolean add(String word) {
        return words.add(word);
    }

    @Override
    public boolean find(String word) {
        return words.contains(word);
    }

    @Override
    public int size() {
        return words.size();
    }
}
