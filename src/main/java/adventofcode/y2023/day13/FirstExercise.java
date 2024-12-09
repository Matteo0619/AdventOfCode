package adventofcode.y2023.day13;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day13/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long totalRow = 0;
        long totalCol = 0;

        List<List<String>> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        String[][] mat = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        int col = mat[0].length;
        int row = mat.length;

        System.out.println(List.of(mat[0]));

        //cycle on row
        for(int i=0; i<row-1; i++) {
            List<String> s1 = list.get(i);
            List<String> s2 = list.get(i+1);

            if(s1.equals(s2)) {
                totalRow++;
            }
        }

        for(int i=0; i<col-1; i++) {
            String[] col1 = new String[col];
            String[] col2 = new String[col];
            for(int j = 0; j < row; j++) {
                col1[i] = mat[j][i];
                col2[i] = mat[j][i+1];
            }

            if(List.of(col1).equals(List.of(col2))) {
                totalCol++;
            }
        }

        System.out.println(totalRow+totalCol);

    }

}
