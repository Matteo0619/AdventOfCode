package adventofcode.y2023.day5;

public class Seed {

    long location;
    long range;
    long lowestLocation;
    long newLocation;
    long lowRange;

    public Seed(long location) {
        this.location = location;
    }

    public Seed(long location, long range) {
        this.location = location;
        this.newLocation = location;
        this.range = range;
        this.lowestLocation = Long.MAX_VALUE;
        this.lowRange = Long.MAX_VALUE;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    public long getRange() {
        return range;
    }

    public void setRange(long range) {
        this.range = range;
    }

    public long getLowestLocation() {
        return lowestLocation;
    }

    public void setLowestLocation(long lowestLocation) {
        this.lowestLocation = lowestLocation;
    }

    public long getLowRange() {
        return lowRange;
    }

    public void setLowRange(long lowRange) {
        this.lowRange = lowRange;
    }

    public long getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(long newLocation) {
        this.newLocation = newLocation;
    }
}
