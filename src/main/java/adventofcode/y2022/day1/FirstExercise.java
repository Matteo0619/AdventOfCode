package adventofcode.y2022.day1;

import java.io.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day1/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int temp = 0;
        int total = 0;

        String line = null;
        while ((line = buffer.readLine()) != null) {
            if("".equalsIgnoreCase(line)) {
                if(temp > total) {
                    total = temp;
                }
                temp = 0;
            } else {
                temp += Integer.parseInt(line);
            }
        }

        System.out.println(total);
    }
}
