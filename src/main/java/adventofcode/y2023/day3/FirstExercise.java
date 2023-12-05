package adventofcode.y2023.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> list = new ArrayList<>();

        while((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        String[][] mat = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        int col = mat[0].length;
        int row = mat.length;

        int total = 0;
        String number = "";
        boolean valid = false;

        for(int r=0;r<row; r++) {
            for(int c=0;c<col;c++) {
                if(isNumeric(mat[r][c])) {
                    number = number.concat(mat[r][c]);
                    if(checkSurrounding(mat, r, c)) {
                        valid = true;
                    }
                } else {
                    if(valid) {
                        total += Integer.parseInt(number);
                    }
                    number = "";
                    valid = false;
                }
            }
        }

        System.out.println(total);


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean checkSurrounding(String[][] list, int x, int y) {
        for(int dx = -1; dx <= 1; dx++) {
            if ((x + dx >= 0) && (x + dx < list.length)) {
                for(int dy = -1; dy <= 1; dy++) {
                    if ((y + dy >= 0) && (y + dy < list[x + dx].length) && (!(dx == 0 && dy == 0))) {
                        if (list[x + dx][y + dy].matches("[^a-zA-Z0-9.]")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
