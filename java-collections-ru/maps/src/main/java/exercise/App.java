package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        if (sentence.length() == 0) {
            return words;
        }
        String[] arrayOfWords = sentence.split(" ");

        for (String word: arrayOfWords) {
            if (words.get(word) == null) {
                words.put(word, 1);
            } else {
                int count = words.get(word) + 1;
                words.put(word, count);
            }

        }
        return words;
    }

    public static String toString(Map<String, Integer> words) {
        var result = new StringBuilder();
        Set<String> keys = words.keySet();
        result.append("{\n");
        if (words.isEmpty()) {
            return "{}";
        }
        for (String key: keys) {
            result.append("  " + key + ": " + words.get(key) + "\n");
        }
        result.append("}\n");
        return result.toString();
    }
}
//END
