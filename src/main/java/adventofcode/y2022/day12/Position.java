package adventofcode.y2022.day12;

public class Position {

    private int row;
    private int col;

    private String value;
    private boolean visited;

    public Position(int row, int col, String value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.visited = false;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                ", value='" + value + '\'' +
                ", visited=" + visited +
                '}';
    }
}
