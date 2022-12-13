package adventofcode.y2021.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day10/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int cycle = 0;
        int register = 1;
        int sum = 0;

        String line = null;
        while ((line = buffer.readLine()) != null) {
            if(line.contains("noop")) {
                cycle++;
                sum = getSum(cycle, register, sum);
            } else {
                int value = Integer.parseInt(line.split(" ")[1]);
                for(int i=0; i<2;i++) {
                    cycle++;
                    sum = getSum(cycle, register, sum);
                }
                register += value;
            }
        }
        System.out.println(sum);
    }

    private static int getSum(int cycle, int register, int sum) {
        if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
            sum += cycle * register;
        }
        return sum;
    }

}
