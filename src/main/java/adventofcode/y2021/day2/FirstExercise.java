package adventofcode.y2021.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int depth = 0;
        int length = 0;

        String line = null;
        while((line = buffer.readLine()) != null) {
            String[] input = line.split(" ");
            switch (input[0]) {
                case "forward" : {
                    length += Integer.parseInt(input[1]);
                    break;
                }
                case "down" : {
                    depth += Integer.parseInt(input[1]);
                    break;
                }
                case "up" : {
                    depth -= Integer.parseInt(input[1]);
                    break;
                }
            }
        }

        System.out.println(depth * length);
    }
}
