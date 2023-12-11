package adventofcode.y2023.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondExercise {


    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day8/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        boolean found = false;
        boolean end;
        int counter = 0;


        String line = null;
        String[] instructions = buffer.readLine().split("");
        Map<String, Direction> map = new HashMap<>();
        List<Node> startingNodes = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            line = line.replace("(", "").replace(")", "");

            String[] arr = line.split(" = ");
            String[] dir = arr[1].split(", ");

            map.put(arr[0], new Direction(dir[0], dir[1]));

            if(arr[0].endsWith("A")) {
                startingNodes.add(new Node(arr[0], arr[0]));
            }

        }


        while (!found) {
            for (String instruction : instructions) {
                counter++;
                for (Node node : startingNodes) {
                    String current = node.getCurrent();
                    if (instruction.equals("L")) {
                        current = map.get(current).getLeft();
                    } else {
                        current = map.get(current).getRight();
                    }
                    node.setCurrent(current);
                }
                end = startingNodes.stream().allMatch(n -> n.getCurrent().endsWith("Z"));
                if(end) {
                    found = true;
                    break;
                }
            }
        }

        System.out.println(counter);

    }

}
