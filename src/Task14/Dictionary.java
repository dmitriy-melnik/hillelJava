package Task14;

import java.util.ArrayList;
import java.util.Iterator;

public class Dictionary {

    private ArrayList<Pair> words = new ArrayList<Pair>();

    public void addWordPair(String english, String russian) {
        words.add(new Pair(english, russian));
    }

    public void deleteWordPair(String english, String russian) {
        Iterator<Pair> wordsIterator = words.iterator();
        while (wordsIterator.hasNext()) {
            Pair p = wordsIterator.next();
            if (p.getWord().equals(english) && p.getRussianTranslate().equals(russian)) {
                wordsIterator.remove();
            }
        }
    }

    public String getRussianTranslate(String english) {
        for (Pair p : words) {
            if (p.getWord().equals(english)) {
                return p.getRussianTranslate();
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return words + "";
    }

    public static class Pair {
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
    }
}
