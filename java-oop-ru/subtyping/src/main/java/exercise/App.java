package exercise;

import java.util.Map;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> temp = storage.toMap();
        for (Map.Entry<String, String> entry: temp.entrySet()) {
            var k = entry.getValue();
            var v = entry.getKey();
            storage.set(k,v);
            storage.unset(v);
        }
    }
}
// END
