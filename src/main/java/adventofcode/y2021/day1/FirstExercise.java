package adventofcode.y2021.day1;

import java.io.*;
import java.nio.Buffer;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int total = 0;
        int previus = Integer.parseInt(buffer.readLine());

        String line = null;

        while ((line = buffer.readLine()) != null) {
            int current = Integer.parseInt(line);
            if(Integer.parseInt(line) > previus) {
                total++;
            }
            previus = current;
        }

        System.out.println(total);
    }
}
