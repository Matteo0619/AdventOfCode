package adventofcode.y2024.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day8/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> grid = new ArrayList<>();
        List<List<String>> clone = new ArrayList<>();

        while ((line = buffer.readLine()) != null ) {
            grid.add(new ArrayList<>(Arrays.asList(line.split(""))));
            clone.add(new ArrayList<>(Arrays.asList(line.split(""))));
        }

        Map<String, List<int[]>> map = new HashMap<>();

        for(int i=0; i<grid.size(); i++) {
            for(int j=0; j<grid.get(i).size(); j++) {
                if(!grid.get(i).get(j).equals(".")) {
                    String s = grid.get(i).get(j);
                    map.putIfAbsent(s, new ArrayList<>());
                    map.get(s).add(new int[] {i,j});
                }
            }
        }

        for(String k : map.keySet()) {
            for (int i = 0; i < map.get(k).size(); i++) {
                for (int j = i + 1; j < map.get(k).size(); j++) {
                    int[] pos1 = map.get(k).get(i);
                    int[] pos2 = map.get(k).get(j);
                    int dX1 = pos1[1] - pos2[1];
                    int dY1 = pos1[0] - pos2[0];
                    int dX2 = pos2[1] - pos1[1];
                    int dY2 = pos2[0] - pos1[0];
                    int[] posAntinode1= new int[]{pos1[0]+dY1, pos1[1]+dX1};
                    int[] posAntinode2= new int[]{pos2[0]+dY2, pos2[1]+dX2};
                    try {
                        clone.get(posAntinode1[0]).set(posAntinode1[1], "#");
                    } catch (Exception ignored){

                    }
                    try {
                        clone.get(posAntinode2[0]).set(posAntinode2[1], "#");
                    } catch (Exception ignored){

                    }
                }
            }
        }

        int counter = 0;

        for (List<String> list : clone) {
            for (String s : list) {
                System.out.print(s);
                if (s.equals("#")) {
                    counter++;
                }
            }
            System.out.print("\n");
        }

        System.out.println(counter);

    }

}
