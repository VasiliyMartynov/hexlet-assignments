package exercise;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;

class App {
    public static String[] duplicateValues(String[] items) {
        System.out.println("---------------------------");
        System.out.println("начало метода duplicateValues");
        System.out.println("---------------------------\n");
        System.out.println("входной массив []\n" + Arrays.deepToString(items));
        System.out.println("создание стрима массива");
        String[] result = Arrays.stream(items)
                .flatMap(item -> {
                    System.out.println("запускаем flatmap");
                    System.out.println("берем элемент " + item + ", удваиваем его:");
                    String[] doubledItem = {item, item};
                    System.out.println(Arrays.toString(doubledItem));
                    System.out.println("возвращаем в flatmap стрим удвоеннго массива");
                    return Arrays.stream(doubledItem);
                })
                .toArray(String[]::new);
        System.out.println("конец метода duplicateValues");
        System.out.println("Итоговый массив" + Arrays.toString(result) + "\n");
        return result;
    }

    public static String[][] enlargeArrayImage(String[][] image) {
        System.out.println("---------------------------");
        System.out.println("исходный двумерный массив[][] \n" + Arrays.deepToString(image));
        System.out.println("---------------------------\n");
        System.out.println("создание стрима двумерного массива");
        System.out.println("Вызов метода horizontalyStretched");
        System.out.println("---------------------------\n");
        String[][] horizontalyStretched = Arrays.stream(image)
                .map(App::duplicateValues)
                .toArray(String[][]::new);
        System.out.println("горизонтально растянытый исходный массив \n" + Arrays.deepToString(horizontalyStretched));
        System.out.println("---------------------------\n");
        System.out.println("создание стрима двумерного массива");
        String[][] result = Arrays.stream(horizontalyStretched)
                .flatMap(item -> {
                    System.out.println("запускаем flatmap");
                    System.out.println("берем элемент " + Arrays.deepToString(item) + ", удваиваем его:");
                    String[][] megaArray = {item, item};
                    System.out.println(Arrays.deepToString(megaArray));
                    System.out.println("возвращаем в flatmap стрим удвоеннго массива");
                    return Arrays.stream(megaArray);
                })
                .toArray(String[][]::new);
        System.out.println("итоговый умноженный массив:\n" + Arrays.deepToString(result));
        return result;
    }
}
//class App {
//    public static String[] duplicateValues(String[] items) {
//
//        return Arrays.stream(items)
//                .flatMap(item -> Arrays.stream(new String[] {item, item}))
//                .toArray(String[]::new);
//    }
//
//    public static String[][] enlargeArrayImage(String[][] image) {
//
//        String[][] horizontalyStretched = Arrays.stream(image)
//                .map(App::duplicateValues)
//                .toArray(String[][]::new);
//
//        return Arrays.stream(horizontalyStretched)
//                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
//                .toArray(String[][]::new);
//    }
//}



