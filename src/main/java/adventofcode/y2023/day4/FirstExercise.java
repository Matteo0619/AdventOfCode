package adventofcode.y2023.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day4/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long total = 0;

        while ((line = buffer.readLine()) != null) {
            String[] arr = line.split(": ");

            String[] l = arr[1].split(" \\| ");

            Set<String> win = new HashSet<>(Set.of(l[0].replaceAll(" {2}", " ").split(" ")));
            Set<String> num = new HashSet<>(Set.of(l[1].replaceAll(" {2}", " ").split(" ")));

            win.retainAll(num);

            //System.out.println("R " + win);

            long occurrence = win.size();

            System.out.println("TOT " + total + " ADD " + (long) Math.pow(2, occurrence-1) +  " RES " +  (total + (long) Math.pow(2, occurrence-1)));


            if(occurrence > 0) {
                //System.out.println("OCC " + occurrence +  " RES " + (long) Math.pow(2, occurrence-1));
                //System.out.println("TOT " + total + " ADD " + (long) Math.pow(2, occurrence-1) +  " RES " +  (total + (long) Math.pow(2, occurrence-1)));
                total += (long) Math.pow(2, occurrence-1);
            }

        }

        System.out.println(total);
    }

}
