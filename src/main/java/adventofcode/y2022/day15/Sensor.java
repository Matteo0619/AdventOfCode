package adventofcode.y2022.day15;

public class Sensor {

    private int x;
    private int y;
    private int distanceB;

    public Sensor(int x, int y, int distanceB) {
        this.x = x;
        this.y = y;
        this.distanceB = distanceB;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistanceB() {
        return distanceB;
    }

    public void setDistanceB(int distanceB) {
        this.distanceB = distanceB;
    }
}
