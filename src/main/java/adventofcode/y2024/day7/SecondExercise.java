package adventofcode.y2024.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day7/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<String> results = new ArrayList<>();
        List<List<String>> numbers = new ArrayList<>();

        while ((line = buffer.readLine()) != null ) {
            String[] arr = line.split(": ");
            results.add(arr[0]);
            numbers.add(List.of(arr[1].split(" ")));
        }

        long total = 0;
        for(int i=0; i<numbers.size(); i++) {
            List<String> comb = getCombinations(numbers.get(i));
            long result = Long.parseLong(results.get(i));

            for(String s : comb) {
                if(result == calculate(s)) {
                    total += result;
                    break;
                }
            }
        }

        System.out.println(total);


    }

    public static List<String> getCombinations(List<String> numbers) {

        List<String> combinations = new ArrayList<>();

        getCombinationsRic(numbers, 0, "", combinations);

        return combinations;

    }

    private static void getCombinationsRic(List<String> numeri, int index, String espressione, List<String> combinazioni) {

        if (index == numeri.size()) {
            combinazioni.add(espressione);
            return;
        }

        if (index == 0) {
            getCombinationsRic(numeri, index + 1, numeri.get(index), combinazioni);
        } else {
            getCombinationsRic(numeri, index + 1, espressione + " + " + numeri.get(index), combinazioni);
            getCombinationsRic(numeri, index + 1, espressione + " * " + numeri.get(index), combinazioni);
            getCombinationsRic(numeri, index + 1, espressione + " || " + numeri.get(index), combinazioni);
        }
    }

    private static long calculate(String s) {


        Queue<String> queue = new LinkedList<>(List.of(s.split(" ")));

        long n1 = 0;
        long n2 = 0;
        long total = 0;
        String op = "";
        while (!queue.isEmpty()) {
            try {
                if(n1 == 0) {
                    Long.parseLong(queue.peek());
                    n1 = Long.parseLong(queue.poll());
                } else {
                    Long.parseLong(queue.peek());
                    n2 = Long.parseLong(queue.poll());
                    if(op.equals("+")) {
                        total = n1 + n2;
                        n1=total;
                        n2=0;
                    } else  if (op.equals("*") ){
                        total = n1 * n2;
                        n1=total;
                        n2=0;
                    } else {
                        total = Long.parseLong(n1 + "" + n2);
                        n1=total;
                        n2=0;
                    }
                }
            } catch (Exception e) {
                op = queue.poll();
            }
        }

        return total;

    }


}
