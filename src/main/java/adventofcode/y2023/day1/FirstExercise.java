package adventofcode.y2023.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int total = 0;

        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");


        String line = null;

        while ((line = buffer.readLine()) != null) {
            int first = 0;
            int last = 0;

            List<String> list = new ArrayList<>(List.of(line.split("")));

            list = list.stream().filter(numbers::contains).collect(Collectors.toList());



            System.out.println(list.get(0).concat(list.get(list.size()-1)));


            total = total + Integer.parseInt(list.get(0).concat(list.get(list.size()-1)));

        }

        System.out.println(total);
    }
}
