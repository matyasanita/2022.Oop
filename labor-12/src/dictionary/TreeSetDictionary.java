package dictionary;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDictionary implements IDictionary{
    private Set<String> words = new TreeSet<>();
    private static TreeSetDictionary instance = null;

    public TreeSetDictionary() {
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
            instance = new TreeSetDictionary();
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
