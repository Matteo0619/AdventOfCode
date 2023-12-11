package adventofcode.y2023.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {


    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day8/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        boolean found = false;
        int counter = 0;


        String line = null;
        String[] instructions = buffer.readLine().split("");
        Map<String, Direction> map = new HashMap<>();

        while ((line = buffer.readLine()) != null) {
            line = line.replace("(", "").replace(")", "");

            String[] arr = line.split(" = ");
            String[] dir = arr[1].split(", ");

            map.put(arr[0], new Direction(dir[0], dir[1]));

        }

        String current = "AAA";

        while (!found) {
            for(int i=0; i<instructions.length; i++) {
                counter++;
                if(instructions[i].equals("L")) {
                    current = map.get(current).getLeft();
                    if(current.equals("ZZZ")) {
                        found = true;
                        break;
                    }
                } else {
                    current = map.get(current).getRight();
                    if(current.equals("ZZZ")) {
                        found = true;
                        break;
                    }
                }
            }
        }

        System.out.println(counter);

    }

}
