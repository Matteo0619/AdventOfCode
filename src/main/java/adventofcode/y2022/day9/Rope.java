package adventofcode.y2022.day9;

public class Rope {

    private int height;
    private int length;

    public Rope() {
        this.height = 0;
        this.length = 0;
    }

    public Rope(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addHeight() {
        this.height += 1;
    }

    public void removeHeight() {
        this.height -= 1;
    }

    public void addLength() {
        this.length += 1;
    }

    public void removeLength() {
        this.length -= 1;
    }

    public boolean isTouching(Rope rope) {
        if(this.getLength() == rope.getLength() && this.getHeight() == rope.getHeight()) {
            return true;
        }
        if(sameLine(rope)) {
            return  this.getLength() == rope.getLength()-1 || this.getLength() == rope.getLength()+1;
        }

        if(sameColumn(rope)) {
            return  this.getHeight() == rope.getHeight()-1 || this.getHeight() == rope.getHeight()+1;
        }

        return (rope.getHeight() == this.getHeight()+1 && rope.getLength() == this.getLength()+1) || (rope.getHeight() == this.getHeight()+1 && rope.getLength() == this.getLength()-1) ||
                (rope.getHeight() == this.getHeight()-1 && rope.getLength() == this.getLength()+1) || (rope.getHeight() == this.getHeight()-1 && rope.getLength() == this.getLength()-1);
    }

    public boolean sameColumn(Rope rope) {
        return this.getLength() == rope.getLength();
    }

    public boolean sameLine(Rope rope) {
        return  this.getHeight() == rope.getHeight();
    }

    public boolean isUpLeft(Rope rope) {
        return this.height > rope.getHeight() && this.getLength() < rope.getLength();
    }

    public boolean isUpRight(Rope rope) {
        return this.height > rope.getHeight() && this.getLength() > rope.getLength();
    }

    public boolean isdDownLeft(Rope rope) {
        return this.height < rope.getHeight() && this.getLength() < rope.getLength();
    }

    public boolean isDownRight(Rope rope) {
        return this.height < rope.getHeight() && this.getLength() > rope.getLength();
    }

    @Override
    public boolean equals(Object o) {
        Rope r = (Rope) o;
        return this.length == r.getLength() && this.height == r.getHeight();
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + length;
        return result;
    }
}
