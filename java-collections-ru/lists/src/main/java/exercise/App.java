package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static Boolean scrabble(String chars, String word) {
        if (chars.isEmpty() || word.isEmpty()) {
            return false;
        }
        List<String> charsInList = new ArrayList<>();
        List<String> wordInList = new ArrayList<>();
        fillList(charsInList, chars);
        fillList(wordInList, word);
        System.out.println("Original lists");
        System.out.println(wordInList);
        System.out.println(charsInList);
        System.out.println("--------------------");
        System.out.println("");
        String someLetter;
        do {
            someLetter = wordInList.get(0);
            if (charsInList.contains(someLetter)) {
                System.out.println("charlist is contain " + someLetter);
                charsInList.remove(charsInList.indexOf(someLetter));
                wordInList.remove(wordInList.indexOf(someLetter));
                System.out.println("Deleting founded letter " + someLetter);
                System.out.println(wordInList);
                System.out.println(charsInList);
                System.out.println("--------------------");

            } else {
                System.out.println("charlist isn't contain " + someLetter);
                return false;
            }
        } while (!wordInList.isEmpty());
        return true;
    }
    private static List<String> fillList(List<String> arrayList, String word) {
        for (int i = 0; i < word.length(); i++) {
            arrayList.add(Character.toString(word.charAt(i)).toLowerCase());
        }
        return arrayList;
    }
//    private static Boolean isConsist(List<String> arrayList, String string) {
//            if (arrayList.contains(string)) {
//                return true;
//        }
//        return false;
//    }

}


//END
