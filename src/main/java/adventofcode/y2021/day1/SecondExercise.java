package adventofcode.y2021.day1;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int counter = 1;
        int total = 0;
        int previus = 0;
        int count = 0;

        String line = null;
        
        while ((line = buffer.readLine()) != null) {
            total += Integer.parseInt(line);
            if(counter%3 == 0 ) {
                if(total > previus) {
                    count++;
                }
                previus = total;
                total = 0;
            }
            counter++;
        }

        System.out.println(count);
    }
}
