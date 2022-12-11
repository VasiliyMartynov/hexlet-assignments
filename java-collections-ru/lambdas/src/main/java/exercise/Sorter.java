package exercise;

//import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Map;
import java.util.List;
//import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {

        List<String> result = users.stream()
                .filter(x -> x.get("gender").equals("male"))
                .sorted((u1, u2) -> u1.get("birthday").compareTo(u2.get("birthday")))
                .map(x -> x.get("name"))
                .collect(Collectors.toList());
        return result;
    }
}
// END
