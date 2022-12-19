package exercise;

import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Map;

// BEGIN
public class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        TreeSet<String> keysOfMaps = new TreeSet<>();
        keysOfMaps.addAll(data1.keySet());
        keysOfMaps.addAll(data2.keySet());
        for (String key : keysOfMaps) {
            if (data2.containsKey(key) && !data1.containsKey(key)) {
                result.put(key, "added");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (data1.containsKey(key) && data2.containsKey(key) && !data1.get(key).equals(data2.get(key))) {
                result.put(key, "changed");
            } else if (data1.containsKey(key) && data2.containsKey(key) && data1.get(key).equals(data2.get(key))) {
                result.put(key, "unchanged");
            }
        }
        return result;
    }
}

//END
