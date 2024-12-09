package adventofcode.y2024.day2;

import java.io.*;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split(" ");
            List<String> l = new ArrayList<>(List.of(arr));
            list.add(l);
        }

        System.out.println(countSafe(list));
    }

    public static boolean isSafe(List<String> list) {

        boolean crescente = Integer.parseInt(list.get(1)) > Integer.parseInt(list.get(0));
        boolean decresente = Integer.parseInt(list.get(1)) < Integer.parseInt(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i-1)));

            if (diff < 1 || diff > 3) {
                return false;
            }

            if (Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i-1))) {
                if (decresente) return false;
            } else if (Integer.parseInt(list.get(i)) < Integer.parseInt(list.get(i-1))) {
                if (crescente) return false;
            }
        }

        return true;
    }

    public static int countSafe(List<List<String>> reports) {
        int safeCount = 0;
        for (List<String> report : reports) {
            if (isSafe(report)) {
                safeCount++;
            }
        }
        return safeCount;
    }


}
