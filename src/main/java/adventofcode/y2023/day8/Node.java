package adventofcode.y2023.day8;

public class Node {

    private String start;

    private String current;

    public Node(String start, String current) {
        this.start = start;
        this.current = current;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
