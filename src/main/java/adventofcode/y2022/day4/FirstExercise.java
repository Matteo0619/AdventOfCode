package adventofcode.y2022.day4;

import java.io.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day4/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        int total = 0;

        while((line = buffer.readLine()) != null) {
            String[] pair = line.split(",");
            String[] first = pair[0].split("-");
            String[] second = pair[1].split("-");

            System.out.println(first.toString() +" " + second.toString());

            if((Integer.parseInt(first[0]) <= Integer.parseInt(second[0]) &&
            Integer.parseInt(first[1]) >= Integer.parseInt(second[1])) || ((Integer.parseInt(second[0]) <= Integer.parseInt(first[0]) &&
                    Integer.parseInt(second[1]) >= Integer.parseInt(first[1])))) {
                total++;
            }
        }

        System.out.println(total);
    }
}
