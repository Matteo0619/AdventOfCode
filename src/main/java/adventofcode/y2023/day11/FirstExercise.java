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
            List<String> row = new ArrayList<>();
            for(String s : line.split("")) {
                row.add(s);
            }
            list.add(row);
        }

        List<List<String>> copy = List.copyOf(list);

        int counter = 0;
        for(List<String> l: copy) {
            if(!l.contains("#")) {
                list.add(counter+1, l);
            }
            counter ++;
        }

        copy = List.copyOf(list);
        counter=0;
        int size = copy.size();

        for(int i=0; i<size; i++) {
            int copyI = i;
            int finalI = i+counter;
            if(copy.stream().noneMatch(l-> l.get(copyI).equals("#"))) {
                for(List<String> l : list) {
                    l.add(finalI+1, ".");
                }
                counter++;

            }
        }

        String[][] mat = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        List<Galaxy> galaxies = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j].equals("#")) {
                   galaxies.add(new Galaxy(i, j));
                }
            }

        }


        for(int i=0; i<galaxies.size()-1; i++) {
            for(int j=i+1; j<galaxies.size(); j++) {
                Galaxy from = galaxies.get(i);
                Galaxy to = galaxies.get(j);

                total += (Math.abs(to.getCordR()-from.getCordR()) + Math.abs(to.getCordC()-from.getCordC()));
            }
        }

        System.out.println(total);


    }



}
