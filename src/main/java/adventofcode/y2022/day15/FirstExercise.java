package adventofcode.y2022.day15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day15/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        Set<Integer> free = new HashSet<>();
        Set<Integer> beacon = new HashSet<>();
        int row = 2000000;
        String line = null;
        while ((line = buffer.readLine()) != null) { //Sensor at x=2483411, y=3902983: closest beacon is at x=2289579, y=3633785
            line = line.replace("Sensor at x=", "").replace(", y=", " ").replace(": closest beacon is at x=", " ");
            String[] arr = line.split(" ");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            int x2 = Integer.parseInt(arr[2]);
            int y2 = Integer.parseInt(arr[3]);
            int distanceSB = Math.abs(x1-x2) + Math.abs(y1-y2);
            int distanceSL = Math.abs(y1-row);

            if(y2 == row) {
                beacon.add(x2);
            }

            if(distanceSL > distanceSB) {
                continue;
            }

            int diff = distanceSB - distanceSL;
            for(int i=x1-diff; i<=x1+diff; i++) {
                free.add(i);
            }
        }

        System.out.println(free.size() - beacon.size());
    }
}
