package dictionary;

public class Main {

    public static void measureTime(DictionaryType dictionaryType){

        System.out.println("--------" + dictionaryType + "--------");

        long startTime = System.nanoTime();
        DictionaryService service = new
                DictionaryService(dictionaryType);
        service.findWordsFile("bible.txt");
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " +
                timeElapsed / 1000000);
    }

    public static void main(String[] args) {
        for (DictionaryType type : DictionaryType.values()){
            measureTime(type);
        }
    }
}
