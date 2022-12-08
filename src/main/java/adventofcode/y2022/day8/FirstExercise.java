package adventofcode.y2022.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day8/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> list = new ArrayList<>();

        while((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        String[][] arr = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        int col = arr[0].length;
        int row = arr.length;

        int border = 0;

        int visible = 0;


        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(Utility.isBorder(i, j, row, col)) {
                    border++;
                } else if (Utility.isVisible(arr, i, j)) {
                    visible ++;
                }
            }
        }

        System.out.println(visible  + border);


    }

}

