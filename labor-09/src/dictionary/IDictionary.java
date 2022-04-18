package dictionary;

public interface IDictionary {
    final String DICTIONARY_FILE = "dictionary_input.txt";
    boolean add(String word);
    boolean find (String word);
    int size();
}
