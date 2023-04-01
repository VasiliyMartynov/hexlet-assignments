package exercise;

// BEGIN
public class Circle {
    int r;
    Point center;
    Circle(Point p, int radius) {
        this.center = p;
        this.r = radius;
    }

    public int getRadius() {
        return r;
    }

    public double getSquare() throws NegativeRadiusException{
        if (this.getRadius() < 0) {
            throw new NegativeRadiusException("");
        }
        return Math.PI * r * r;
    }
}
// END
