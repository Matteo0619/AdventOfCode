package adventofcode.y2022.day11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day11/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<BigMonkey> monkeys = new ArrayList<>();

        while((line = buffer.readLine()) != null) {
            String items = buffer.readLine().replace("  Starting items: ", "");
            String[] arr = items.split(", ");
            List<BigItem> list = new ArrayList<>();
            for(String s : arr) {
                list.add(new BigItem(s));
            }
            String operation = buffer.readLine().replace("  Operation: new = ", "");
            String[] arr2 = operation.split(" ");
            String opType = arr2[1];
            String op = arr2[2];
            int divisible = Integer.parseInt(buffer.readLine().replace("  Test: divisible by ", ""));
            int testTrue = Integer.parseInt(buffer.readLine().replace("    If true: throw to monkey ", ""));
            int testFalse = Integer.parseInt(buffer.readLine().replace("    If false: throw to monkey ", ""));
            monkeys.add(new BigMonkey(list, op, opType, divisible, testTrue, testFalse));
        }

        for(int i=0; i<10000; i++) {
            System.out.println(i);
            for(int c=0; c<monkeys.size(); c++) {
                BigMonkey monkey = monkeys.get(c);
                List<BigItem> items = monkey.getList();
                List<BigItem> copy = List.copyOf(items);
                if(items.size() != 0) {
                    for(BigItem item : copy) {
                        monkey.addInspected();
                        calculateNewValue(item, monkey);
                        int divisible = monkey.getDivisible();
                        int testTrue = monkey.getTestTrue();
                        int testFalse = monkey.getTestFalse();
                        if(Utility.isDivisible(item.getValue(), divisible)) {
                            BigMonkey m = monkeys.get(testTrue);
                            m.getList().add(item);
                        } else {
                            BigMonkey m = monkeys.get(testFalse);
                            m.getList().add(item);
                        }
                        items.remove(item);
                    }
                }
            }
        }

        List<Integer> inspected = monkeys.stream().map(BigMonkey::getInspected).collect(Collectors.toList());
        Collections.sort(inspected, Collections.reverseOrder());
        System.out.println(inspected);
        System.out.println(inspected.stream().limit(2).collect(Collectors.toList()));

    }

    public static void calculateNewValue(BigItem item, BigMonkey monkey) {
        String input = "0";

        try {
            input = monkey.getOperation();
        } catch (NumberFormatException e) {
            input = item.getValue();
        }

        String opType = monkey.getOpType();
        String value = item.getValue();

        switch (opType) {
            case "+" : {
                value = Utility.sum(input, value);
                break;
            }
            case "*" : {
                value = Utility.multiply(input, value);
                break;
            }
        }

        item.setValue(value);
    }

}
