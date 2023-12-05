package adventofcode.y2023.day3;

import java.util.Objects;

public class Gear {

    int row;
    int column;

    int part1;
    int part2;

    public Gear(int row, int column) {
        this.part1 = 0;
        this.part2 = 0;
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPart1() {
        return part1;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public int getPart2() {
        return part2;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return row == gear.row && column == gear.column && part1 == gear.part1 && part2 == gear.part2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, part1, part2);
    }

    @Override
    public String toString() {
        return "Gear{" +
                "row=" + row +
                ", column=" + column +
                ", part1=" + part1 +
                ", part2=" + part2 +
                '}';
    }
}
