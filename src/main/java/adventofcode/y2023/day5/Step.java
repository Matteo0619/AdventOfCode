package adventofcode.y2023.day5;

public class Step {

    long source;
    long destination;
    long range;

    public Step(long source, long destination, long range) {
        this.source = source;
        this.destination = destination;
        this.range = range;
    }

    public long getSource() {
        return source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public long getRange() {
        return range;
    }

    public void setRange(long range) {
        this.range = range;
    }
}
