package adventofcode.y2021.day2;

import java.io.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int depth = 0;
        int length = 0;
        int aim = 0;

        String line = null;
        while((line = buffer.readLine()) != null) {
            String[] input = line.split(" ");
            switch (input[0]) {
                case "forward" : {
                    length += Integer.parseInt(input[1]);
                    depth += aim * Integer.parseInt(input[1]);
                    break;
                }
                case "down" : {
                    aim += Integer.parseInt(input[1]);
                    break;
                }
                case "up" : {
                    aim -= Integer.parseInt(input[1]);
                    break;
                }
            }
        }

        System.out.println(depth * length);
    }
}
