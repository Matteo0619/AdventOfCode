package adventofcode.y2024.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<Long> l1 = new ArrayList<>();
        List<Long> l2 = new ArrayList<>();
        Long c = 0L;

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split("   ");
            l1.add(Long.valueOf(arr[0]));
            l2.add(Long.valueOf(arr[1]));
        }

        Long total = 0L;
        for(Long l : l1) {
            total += l * Collections.frequency(l2, l);
        }

        System.out.println(total);

    }
}
