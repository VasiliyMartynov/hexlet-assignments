package exercise;

// BEGIN
class Cottage implements Home {

    private final double area;
    private final int floorCount;

    Cottage (double areaC, int floorCountC) {
        this.area = areaC;
        this.floorCount = floorCountC;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    public String toString() {
        return String.format("%s этажный коттедж площадью %s метров", this.floorCount, this.getArea());
    }
}
// END
