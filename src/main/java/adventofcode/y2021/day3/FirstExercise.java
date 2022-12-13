package adventofcode.y2021.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int iteration = 0;
        int[] array = new int[12];
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsylon = new StringBuilder();

        String line = null;
        while((line = buffer.readLine()) != null) {
           for(int i = 0; i<line.length(); i++) {
               array[i] += Integer.parseInt(String.valueOf(line.charAt(i)));
           }
           iteration++;
        }

        for (int j : array) {
            if (j > (iteration / 2)) {
                gamma.append("1");
                epsylon.append("0");
            } else {
                gamma.append("0");
                epsylon.append("1");
            }
        }

        System.out.println(Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsylon.toString(),2));

    }
}
