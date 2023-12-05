package adventofcode.y2023.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day4/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        int counter = 1;

        Map<Integer, Integer> map = new HashMap<>();

        while ((line = buffer.readLine()) != null) {
            String[] arr = line.split(": ");

            String[] l = arr[1].split(" \\| ");

            Set<String> win = new HashSet<>(Set.of(l[0].replaceAll(" {2}", " ").split(" ")));
            Set<String> num = new HashSet<>(Set.of(l[1].replaceAll(" {2}", " ").split(" ")));

            win.retainAll(num);

            long occurrence = win.size();

            if(!map.containsKey(counter)) {
                map.put(counter, 1);
            } else {
                map.put(counter, map.get(counter)+1);
            }

            for(int i=counter+1; i<=counter+occurrence; i++) {
                if(!map.containsKey(i)) {
                    map.put(i, map.get(counter));
                } else {
                    map.put(i, map.get(i)+map.get(counter));
                }
            }

            counter++;

        }

        long sum = map.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
