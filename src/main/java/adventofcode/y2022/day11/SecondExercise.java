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
        File file = new File("res/2022/day11/test.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<BigMonkey> monkeys = new ArrayList<>();

        while((line = buffer.readLine()) != null) {
            String items = buffer.readLine().replace("  Starting items: ", "");
            String[] arr = items.split(", ");
            List<BigItem> list = new ArrayList<>();
            for(String s : arr) {
                list.add(new BigItem(Long.parseLong(s)));
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

        for(int i=0; i<20; i++) {
            for(int c=0; c<monkeys.size(); c++) {
                BigMonkey monkey = monkeys.get(c);
                List<BigItem> items = monkey.getList();
                List<BigItem> copy = List.copyOf(items);
                if(items.size() != 0) {
                    monkey.setInspected(monkey.getInspected()+items.size());
                    for(BigItem item : copy) {
                        calculateNewValue(item, monkey);
                        int divisible = monkey.getDivisible();
                        int testTrue = monkey.getTestTrue();
                        int testFalse = monkey.getTestFalse();
                        if(isDivisible(item, divisible)) {
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
        int v = 0;
        try {
            v = Integer.parseInt(monkey.getOperation());
        } catch (NumberFormatException e) {
        }
        String opType = monkey.getOpType();

        long first = item.getFirstValue();
        long second = item.getSecondValue();

        System.out.println("F: " + first + " S: " + second);

        switch (opType) {
            case "+" : {
                if(v == 0) {
                    if(second + second < 0) {
                        long toAdd = Math.abs(second + second);
                        second = Long.MAX_VALUE;
                        first += toAdd;
                    } else {
                        second += second;
                    }
                } else {
                    if(second + v < 0) {
                        long toAdd = Math.abs(second + v);
                        second = Long.MAX_VALUE;
                        first += toAdd;
                    } else {
                        second += v;
                    }
                }
            }
            case "*" : {
                if(v == 0) {
                    if(second * second < 0) {
                        long toAdd = Math.abs(second * second);
                        second = Long.MAX_VALUE;
                        first *= toAdd;
                    } else {
                        second *= second;
                    }
                } else {
                    if(first * v < 0) {
                        long toAdd = Math.abs(second * v);
                        second = Long.MAX_VALUE;
                        first *= toAdd;
                    } else {
                        second *= v;
                    }
                }
            }
        }

        item.setFirstValue(first);
        item.setSecondValue(second);
    }

    public static boolean isDivisible(BigItem item, int divisible) {
        long first = item.getFirstValue();
        long second = item.getSecondValue();

        if(first == 0) {
            return second % divisible == 0;
        } else {
            long remain = first % divisible;
            BigInteger big = BigInteger.valueOf(second).add(BigInteger.valueOf(remain));
            return big.remainder(BigInteger.valueOf(divisible)).equals(BigInteger.ZERO);
        }
    }
}
