package adventofcode.y2023.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day4/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<Long> times = List.of(44806572L);
        List<Long> distances = List.of(208158110501102L);

        //List<Integer> times = List.of(7, 15, 30);
        //List<Integer> distances = List.of(9, 40, 200);


        long total = 1;
        long v1 = 0;
        long index = 0;

        for(Long time : times) {

            for(int i=1; i<time; i++) {
                if(i * (time-i) > distances.get(Math.toIntExact(index))) {
                    v1++;
                }
            }
            index++;
            total *= v1;
            v1 = 0;
        }


        System.out.println(total);
    }
}