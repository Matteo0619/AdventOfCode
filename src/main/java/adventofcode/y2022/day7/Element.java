package adventofcode.y2022.day7;

public class Element {
    private String name;

    private String type;
    private int size;

    public Element(String name, int size, String type) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public Element(String name, String type) {
        this.type = type;
        this.name = name;
        this.size = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addSize(int size) {
        this.size += size;
    }

    public boolean isDirectory() {
        return this.type.equals("dir");
    }

}
