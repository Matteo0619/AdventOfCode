package adventofcode.y2022.day16;

import java.util.Objects;

public class Valve {

    private String name;
    private int rate;

    private boolean open;

    public Valve(String name, int rate) {
        this.name = name;
        this.rate = rate;
        this.open = false;
    }

    public Valve(String name) {
        this.name = name;
        this.open = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valve valve = (Valve) o;
        return name.equals(valve.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
