package adventofcode.y2023.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day9/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long total = 0;


        while ((line = buffer.readLine()) != null) {

            long sum = 0;

            List<List<String>> sequence = new ArrayList<>();

            sequence.add( new ArrayList<>(List.of(line.split(" "))));

            boolean end = sequence.get(sequence.size()-1).stream().allMatch(s -> s.equals("0"));

            while(!end) {

                String[] arr = sequence.get(sequence.size()-1).toArray(new String[0]);
                List<String> l = new ArrayList<>();

                for(int i=0; i< arr.length-1; i++) {
                    long diff = Long.parseLong(arr[i+1]) - Long.parseLong(arr[i]);
                    l.add(String.valueOf(diff));
                }
                sequence.add(l);

                end = sequence.get(sequence.size()-1).stream().allMatch(s -> s.equals("0"));
            }

            for(List<String> l : sequence) {
                sum += Long.parseLong(l.get(l.size()-1));
            }

            total += sum;


        }

        System.out.println(total);
    }
}
