package exercise;

// BEGIN
public interface Home {
    double getArea();

    default int compareTo(Home home){
            if (this.getArea()  > home.getArea()) {
                return 1;
            } else if (this.getArea()  < home.getArea()) {
                return 1;
            }
            return 0;
        }

}
// END
