package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String params) {
        List<String> variables = Arrays.stream(params.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replace("environment=", ""))
                .map(x -> x.replace("\"", ""))
                .flatMap(x -> Arrays.stream(x.split(",")))
                .filter(x -> x.contains("X_FORWARDED_"))
                .map(x -> x.replace("X_FORWARDED_", ""))
                .peek(System.out::print)
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < variables.size(); i++) {
            result.append(variables.get(i));
            if (i == variables.size() - 1) {
                break;
            }
            result.append(",");
        }
        return result.toString();
    }
}
//END
