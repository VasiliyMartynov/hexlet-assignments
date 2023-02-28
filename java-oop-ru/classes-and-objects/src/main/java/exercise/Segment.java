package exercise;

// BEGIN
class Segment {

    private Point beginPoint;
    private Point endPoint;

    Segment (Point start, Point end) {
        this.beginPoint = start;
        this.endPoint = end;
    }
    public Point getBeginPoint() {
        return this.beginPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getMidPoint() {
        int mediumX = (this.beginPoint.getX() + this.endPoint.getX()) / 2;
        int mediumY = (this.beginPoint.getY() + this.endPoint.getY()) / 2;
        return new Point(mediumX, mediumY);
    }

}
// END
