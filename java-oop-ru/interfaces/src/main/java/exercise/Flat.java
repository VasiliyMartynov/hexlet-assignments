package exercise;

// BEGIN
class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;
    double totalArea;
    Flat (double areaC, double balconyAreaC, int floorC) {
        this.area = areaC;
        this.balconyArea = balconyAreaC;
        this.floor = floorC;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    public String toString() {
        return String.format("Квартира площадью %s метров на %s этаже", this.getArea(), this.floor);
    }
}

// END
