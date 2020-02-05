package Task14;

public class Main {
    public static void main(String[] args) {
        Dictionary firstDictionary = new Dictionary();
        firstDictionary.addWordPair("hello", "привет");
        firstDictionary.addWordPair("cat", "кот");
        firstDictionary.addWordPair("book", "книга");
        System.out.println(firstDictionary);
        /*firstDictionary.deleteWordPair("hello", "привет");
        System.out.println(firstDictionary);*/
        System.out.println(firstDictionary.getRussianTranslate("hello"));
    }
}
