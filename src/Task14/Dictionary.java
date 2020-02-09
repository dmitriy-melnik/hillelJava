package Task14;

import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> words = new HashMap<>();

    public void addWordPair(String english, String russian) {
        words.put(english, russian);
    }

    public void deleteWordPair(String english, String russian) {
        words.remove(english, russian);
    }

    public String getRussianTranslate(String english) {
        return words.get(english) + "";
    }

    @Override
    public String toString() {
        return words + "";
    }

    /*public static class Pair {
        private String word;
        private String russianTranslate;

        public Pair(String word, String russianTranslate) {
            this.word = word;
            this.russianTranslate = russianTranslate;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getRussianTranslate() {
            return russianTranslate;
        }

        public void setRussianTranslate(String russianTranslate) {
            this.russianTranslate = russianTranslate;
        }

        @Override
        public String toString() {
            return word + " - " + russianTranslate;
        }
    }*/
}
