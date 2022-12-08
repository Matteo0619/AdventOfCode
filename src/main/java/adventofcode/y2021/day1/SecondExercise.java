package adventofcode.y2021.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<Integer> list = new ArrayList<>();
        String line = null;
        int incremented = 0;
        int lastSum = Integer.MAX_VALUE;
        int b = 0;
        int e = 3;

        while((line = buffer.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }

        for(int i=0; i<list.size()-2; i++) {
            int sum = list.subList(b, e).stream().mapToInt(Integer::intValue).sum();
            if(sum > lastSum) {
                incremented++;
            }
            lastSum = sum;
            b++;
            e++;
        }

        System.out.println(incremented);
    }
}
