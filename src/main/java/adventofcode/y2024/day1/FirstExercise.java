package adventofcode.y2024.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        Map<Long, Long> first = new HashMap<>();
        Map<Long, Long> second = new HashMap<>();
        Long c = 0L;

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split("   ");
            first.put(c, Long.valueOf(arr[0]));
            second.put(c, Long.valueOf(arr[1]));
            c++;
        }

        List<Map.Entry<Long, Long>> l1o = new ArrayList<>(first.entrySet());
        List<Map.Entry<Long, Long>> l2o = new ArrayList<>(second.entrySet());

        l1o.sort(Map.Entry.comparingByValue());
        l2o.sort(Map.Entry.comparingByValue());

        Map<Long, Long> m1o = new LinkedHashMap<>();
        for (Map.Entry<Long, Long> entry : l1o) {
            m1o.put(entry.getKey(), entry.getValue());
        }

        Map<Long, Long> m2o = new LinkedHashMap<>();
        for (Map.Entry<Long, Long> entry : l2o) {
            m2o.put(entry.getKey(), entry.getValue());
        }

        int c1 = 0;
        Long total = 0L;
        List<Map.Entry<Long, Long>> l1 = new ArrayList<>(m1o.entrySet());
        List<Map.Entry<Long, Long>> l2 = new ArrayList<>(m2o.entrySet());
        for(int i=0; i<m1o.keySet().size(); i++) {
            total += Math.abs(l1.get(i).getValue() - l2.get(i).getValue());
        }

        System.out.println(total);

    }
}
