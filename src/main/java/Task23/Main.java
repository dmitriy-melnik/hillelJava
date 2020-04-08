package Task23;

import javax.swing.plaf.basic.BasicBorders;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        /*System.out.println(md5Custom("password"));
        System.out.println(findWord(4, "f016441d00c16c9b912d05e9d81d894d"));*/

        // f016441d00c16c9b912d05e9d81d894d - very
        // 5ebe2294ecd0e0f08eab7690d2a6ee69 - secret
        // 13d70e09909669272b19647c2a55dacb -
        // 5f50dfa5385e66ce46ad8d08a9c9be68 -

//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        GenerateWords generateWordsFirstPart = new GenerateWords("13d70e09909669272b19647c2a55dacb", 1);
//        GenerateWords generateWordsSecondPart = new GenerateWords("13d70e09909669272b19647c2a55dacb", 2);
//        GenerateWords generateWordsThirdPart = new GenerateWords("13d70e09909669272b19647c2a55dacb", 3);
//        GenerateWords generateWordsFourthPart = new GenerateWords("13d70e09909669272b19647c2a55dacb", 4);
//
//        executorService.submit(generateWordsFirstPart);
//        executorService.submit(generateWordsSecondPart);
//        executorService.submit(generateWordsThirdPart);
//        executorService.submit(generateWordsFourthPart);
//        executorService.shutdownNow();

        Role role = Role.USER;
        System.out.println(role.toString());


    }

    public static enum Role {
        USER, ADMIN;
    }

    public static class GenerateWords implements Runnable {
        private String hash;
        private int part;
        private char[] letters = new char[26];

        public GenerateWords(String hash, int part) {
            this.hash = hash;
            this.part = part;
            for (int i = 0; i < 26; i++) {
                letters[i] = (char) ('a' + i);
            }
        }

        @Override
        public void run() {
            int wordLength = 1;
            while (true) {

                char[] word = new char[wordLength];
                long totalWordsCount = 1;

                for (int i = 0; i < wordLength; i++) {
                    totalWordsCount *= letters.length;
                }
                long start = 0;
                long end = 0;

                switch (part) {
                    case 1: {
                        start = 0;
                        end = totalWordsCount / 4;
                        break;
                    }
                    case 2: {
                        start = totalWordsCount / 4;
                        end = (totalWordsCount / 4) * 2;
                        break;
                    }
                    case 3: {
                        start = (totalWordsCount / 4) * 2;
                        end = (totalWordsCount / 4) * 3;
                        break;
                    }
                    case 4: {
                        start = (totalWordsCount / 4) * 3;
                        end = totalWordsCount;
                        break;
                    }
                    default:
                        break;
                }

                for (long i = start; i < end; i++) {
                    long accum = i;
                    for (int j = word.length - 1; j >= 0; j--) {
                        word[j] = letters[(int)accum % letters.length];
                        accum /= letters.length;
                    }
                    //System.out.println(String.valueOf(word));
                    String result = String.valueOf(word);
                    if (md5Custom(result).equals(hash)) {
                        System.out.println(result);
                        break;
                    }
                }
                wordLength++;
            }
        }
    }


    public static String findWord(String hash) {
        int wordLength = 1;
        char[] letters = new char[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('a' + i);
        }

        while (true) {
            char[] word = new char[wordLength];
            int totalWordsCount = 1;

            for (int i = 0; i < wordLength; i++) {
                totalWordsCount *= letters.length;
            }

            for (int i = 0; i < totalWordsCount; i++) {
                int accum = i;
                for (int j = word.length - 1; j >= 0; j--) {
                    word[j] = letters[accum % letters.length];
                    accum /= letters.length;
                }
                //System.out.println(String.valueOf(word));
                String result = String.valueOf(word);
                if (md5Custom(result).equals(hash)) {
                    return result;
                }
            }
            wordLength++;
        }
    }

    public static String findWord(int wordLength, String hash) {
        char[] letters = new char[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('a' + i);
        }

        char[] word = new char[wordLength];
        int totalWordsCount = 1;

        for (int i = 0; i < wordLength; i++) {
            totalWordsCount *= letters.length;
        }
        //System.out.println(totalWordsCount);

        for (int i = 0; i < totalWordsCount; i++) {
            int accum = i;
            for (int j = word.length - 1; j >= 0; j--) {
                word[j] = letters[accum % letters.length];
                accum /= letters.length;
            }
            //System.out.println(String.valueOf(word));
            String result = String.valueOf(word);
            if (md5Custom(result).equals(hash)) {
                return result;
            }
        }
        return "not found";
    }

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
