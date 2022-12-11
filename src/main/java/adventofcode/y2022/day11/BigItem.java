package adventofcode.y2022.day11;

import java.math.BigInteger;

public class BigItem {

    private long firstValue;

    private long secondValue;

    public BigItem(long value) {
        this.firstValue = 0;
        this.secondValue = value;
    }

    public long getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(long firstValue) {
        this.firstValue = firstValue;
    }

    public long getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(long secondValue) {
        this.secondValue = secondValue;
    }
}
