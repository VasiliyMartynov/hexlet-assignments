package exercise;

//import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
//import java.util.stream.Stream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] array = Arrays.stream(image)
                .map(App::doubleArrayItem)
                .toArray(String[][]::new);

        return Arrays.stream(array)
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .toArray(String[][]::new);
    }

    public static String[] doubleArrayItem(String[] items) {
        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(String[]::new);

    }
}


// END
