package adventofcode.y2023.day8;

public class Node {

    private String current;
    private long counter;

    public Node(String start, String current) {
        this.counter = 0;
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }
}
