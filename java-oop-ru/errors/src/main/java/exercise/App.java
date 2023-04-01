package exercise;

// BEGIN
public class App {

    static void printSquare(Circle circle) {

        try{
            Long l = Math.round(circle.getSquare());
            System.out.printf(l.toString());
        } catch (NegativeRadiusException exception) {
            System.out.printf("Не удалось посчитать площадь");
        } finally {
            System.out.printf("\nВычисление окончено");
        }
    }

}
// END
