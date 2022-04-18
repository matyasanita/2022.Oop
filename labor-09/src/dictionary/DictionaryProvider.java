package dictionary;

public class DictionaryProvider{
    public static IDictionary createDictionary(DictionaryType dictionaryType){
        IDictionary dictionary = null;
        switch( dictionaryType ){
            case ARRAY_LIST : dictionary = ArrayListDictionary.newInstance(); break;
            //case HASH_SET -> dictionary = HashSetDictionary.newInstance();
            //case TREE_SET -> dictionary = TreeSetDictionary.newInstance();
        }
        return dictionary;
    }
}
