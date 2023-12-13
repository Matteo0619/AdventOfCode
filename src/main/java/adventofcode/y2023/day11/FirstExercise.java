package adventofcode.y2023.day11;

import adventofcode.y2023.day10.Direction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day11/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long total = 0;

        List<List<String>> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        List<List<String>> copy = List.copyOf(list);

        int counter = 0;
        //add row
        for(List<String> l: copy) {
            if(!l.contains("#")) {
                list.add(counter+1, l);
            }
            counter ++;
        }


        int modified=0;

        //add column
        for(int i=0; i<list.get(0).size(); i++) {
            int finalI = i;
            if(list.stream().noneMatch(l -> l.get(finalI).equals("#"))) {

                for(List<String> l : list) {
                    StringBuilder builder = new StringBuilder(String.join("", l));
                    l = List.of(builder.insert(finalI+1, ".").toString().split(""));
                }
            }
        }

        //transform to matrix
        String[][] mat = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        int col = mat[0].length;
        int row = mat.length;

        //find all galaxies
        List<Galaxy> galaxies = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j].equals("#")) {
                   galaxies.add(new Galaxy(i, j));
                }
            }

        }


        //sum distances between galaxies
        for(int i=0; i<galaxies.size()-1; i++) {
            for(int j=i+1; j<galaxies.size(); j++) {
                Galaxy from = galaxies.get(i);
                Galaxy to = galaxies.get(j);

                total += (Math.abs(to.getCordR()-from.getCordR()) + Math.abs(to.getCordC()-from.getCordC()));
            }
        }

        System.out.println(total);


    }

    public static String[][] addColumn(String[][] mat, String[] column, int index) {
        String[][] result = new String[mat.length][mat[0].length+1];

        for(int r=0; r< mat.length; r++) {
            System.arraycopy(mat[r], 0, result[r], 0, index);
            result[r][index] = column[r];
            System.arraycopy(mat[r], index, result[r], index+1, mat[0].length-index);
        }

        return result;
    }



}
