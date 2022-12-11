package adventofcode.y2022.day11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day11/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<Monkey> monkeys = new ArrayList<>();

        while((line = buffer.readLine()) != null) {
            String items = buffer.readLine().replace("  Starting items: ", "");
            String[] arr = items.split(", ");
            List<Item> list = new ArrayList<>();
            for(String s : arr) {
                list.add(new Item(Integer.parseInt(s)));
            }
            String operation = buffer.readLine().replace("  Operation: new = ", "");
            String[] arr2 = operation.split(" ");
            String opType = arr2[1];
            String op = arr2[2];
            int divisible = Integer.parseInt(buffer.readLine().replace("  Test: divisible by ", ""));
            int testTrue = Integer.parseInt(buffer.readLine().replace("    If true: throw to monkey ", ""));
            int testFalse = Integer.parseInt(buffer.readLine().replace("    If false: throw to monkey ", ""));
            monkeys.add(new Monkey(list, op, opType, divisible, testTrue, testFalse));
        }

        for(int i=0; i<20; i++) {
            for(int c=0; c<monkeys.size(); c++) {
                Monkey monkey = monkeys.get(c);
                List<Item> items = monkey.getList();
                List<Item> copy = List.copyOf(items);
                if(items.size() != 0) {
                    monkey.setInspected(monkey.getInspected()+items.size());
                    for(Item item : copy) {
                        int value = item.getValue();
                        value = calculateNewValue(value, monkey);
                        int divisible = monkey.getDivisible();
                        value = value / 3;
                        item.setValue(value);
                        int testTrue = monkey.getTestTrue();
                        int testFalse = monkey.getTestFalse();
                        if(value % divisible == 0) {
                            Monkey m = monkeys.get(testTrue);
                            m.getList().add(item);
                        } else {
                            Monkey m = monkeys.get(testFalse);
                            m.getList().add(item);
                        }
                        items.remove(item);
                    }
                }
            }
        }

        List<Integer> inspected = monkeys.stream().map(Monkey::getInspected).collect(Collectors.toList());
        Collections.sort(inspected, Collections.reverseOrder());
        System.out.println(inspected);
        System.out.println(inspected.stream().limit(2).collect(Collectors.toList()));

    }

    public static int calculateNewValue(int value, Monkey monkey) {
        int v;
        try {
            v = Integer.parseInt(monkey.getOperation());
        } catch (NumberFormatException e) {
            v = value;
        }
        String opType = monkey.getOpType();

        switch (opType) {
            case "+" : {
                value += v;
                break;
            }
            case "*" : {
                value *= v;
                break;
            }
        }

        return value;
    }
}
