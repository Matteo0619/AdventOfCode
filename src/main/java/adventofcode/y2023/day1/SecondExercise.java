package adventofcode.y2023.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int total = 0;

        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");


        String line = null;

        while ((line = buffer.readLine()) != null) {
            int indexFirst = Integer.MAX_VALUE;
            int indexLast = -1;

            List<String> list = new ArrayList<>(List.of(line.split("")));

            for(String s : numbers) {
                int i = line.indexOf(s);
                int f = line.lastIndexOf(s);

                if(i != -1 && i < indexFirst) {
                    indexFirst = i;
                }

                if(f != -1 && f > indexLast) {
                    indexLast = f;
                }
            }


        }

        System.out.println(total);
    }
}
