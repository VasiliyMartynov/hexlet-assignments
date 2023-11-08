package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN

    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> result = new HashMap<>();
        MinThread min = new MinThread(numbers);
        MaxThread max = new MaxThread(numbers);
        min.run();
        max.run();
        result.put("min", min.getMin());
        result.put("max", max.getMax());
        return result;
    }
    // END
}
