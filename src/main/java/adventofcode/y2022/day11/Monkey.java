package adventofcode.y2022.day11;

import java.util.List;

public class Monkey {

    private List<Item> list;

    private String operation;

    private String opType;

    private int divisible;

    private int testTrue;

    private int testFalse;

    private int inspected;

    public Monkey(List<Item> list, String operation, String opType, int divisible, int testTrue, int testFalse) {
        this.list = list;
        this.operation = operation;
        this.opType = opType;
        this.divisible = divisible;
        this.testTrue = testTrue;
        this.testFalse = testFalse;
        this.inspected = 0;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public int getDivisible() {
        return divisible;
    }

    public void setDivisible(int divisible) {
        this.divisible = divisible;
    }

    public int getTestTrue() {
        return testTrue;
    }

    public void setTestTrue(int testTrue) {
        this.testTrue = testTrue;
    }

    public int getTestFalse() {
        return testFalse;
    }

    public void setTestFalse(int testFalse) {
        this.testFalse = testFalse;
    }

    public int getInspected() {
        return inspected;
    }

    public void setInspected(int inspected) {
        this.inspected = inspected;
    }
}
