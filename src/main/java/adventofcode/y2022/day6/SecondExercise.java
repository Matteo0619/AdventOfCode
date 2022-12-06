package adventofcode.y2022.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day6/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        String input = buffer.readLine();
        int b = 0;
        int e = 14;

        Set<String> set = new HashSet<String>();

        for(int i = 0; i<input.length()-14; i++) {
            String[] sub = input.substring(b, e).split("");
            set.addAll(Arrays.asList(sub));

            if(set.size() == 14) {
                continue;
            }
            b++;
            e++;
            set.clear();
        }

        System.out.println(e);


    }
}
