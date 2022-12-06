package adventofcode.y2022.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<Integer> list = new ArrayList<>();
        int temp = 0;

        String line = null;
        while ((line = buffer.readLine()) != null) {
            if("".equalsIgnoreCase(line)) {
                list.add(temp);
                temp = 0;
            } else {
                temp += Integer.parseInt(line);
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.stream().limit(3).mapToInt(Integer::intValue).sum());
    }
}
