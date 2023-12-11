package adventofcode.y2023.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    static List<String> NORTH = List.of("|", "F", "7");
    static List<String> SOUTH = List.of("|", "J", "L");
    static List<String> WEST = List.of("-", "L", "F");
    static List<String> EAST = List.of("-", "7", "J");

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day10/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long total = 0;

        List<List<String>> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        String[][] mat = list.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);

        int col = mat[0].length;
        int row = mat.length;

        int sCol = -1;
        int sRow = -1;

        //print matrix
//        for (int i = 0; i < mat.length; i++) {
//            // Loop through all elements of current row
//            for (int j = 0; j < mat[i].length; j++) {
//                System.out.print(mat[i][j]);
//            }
//            System.out.println("\n");

        for (int i = 0; i < mat.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j].equals("S")) {
                    sRow = i;
                    sCol = j;
                    break;
                }
            }

            if(sRow != -1) {
                break;
            }
        }

        int counter = 1;
        boolean finish = false;
        int cRow = sRow;
        int cCol = sCol;
        Direction next = null;
        Direction origin = null;

        if(isValid(mat, sRow, sCol, Direction.NORTH)) {
            cRow--;
            origin = Direction.SOUTH;
            next = Direction.NORTH;
        } else if(isValid(mat, sRow, sCol, Direction.SOUTH)) {
            cRow++;
            origin = Direction.NORTH;
            next = Direction.SOUTH;
        } else if(isValid(mat, sRow, sCol, Direction.WEST)) {
            cCol--;
            origin = Direction.EAST;
            next = Direction.WEST;
        } else if(isValid(mat, sRow, sCol, Direction.EAST)) {
            cCol++;
            origin = Direction.WEST;
            next = Direction.EAST;
        }

        while (!finish) {
            counter++;
            next = nextDirection(mat[cRow][cCol], origin);
            origin = getOrigin(mat[cRow][cCol], next);

            //mat[cRow][cCol] = "&";

            if(next.equals(Direction.NORTH)) {
                cRow--;
            } else if(next.equals(Direction.SOUTH)) {
                cRow++;
            } else if(next.equals(Direction.WEST)) {
                cCol--;
            } else if(next.equals(Direction.EAST)) {
                cCol++;
            }

            if(mat[cRow][cCol].equals("S")) {
                finish = true;
            }

        }

        for (int i = 0; i < mat.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j].equals("S") || mat[i][j].equals("&")) {
                    System.out.print(mat[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("\n");
        }

        System.out.println(counter/2);


    }

    public static boolean isValid(String[][] mat, int row, int col, Direction direction) {

        try {
            if(direction.equals(Direction.NORTH)) {
                return  NORTH.contains(mat[row][col+1]);
            } else if(direction.equals(Direction.SOUTH)) {
                return  SOUTH.contains(mat[row][col+1]);
            } else if(direction.equals(Direction.WEST)) {
                return  WEST.contains(mat[row][col+1]);
            } else if(direction.equals(Direction.EAST)) {
                return  EAST.contains(mat[row][col+1]);
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return false;

    }

    public static Direction nextDirection(String pipe, Direction origin) {

        switch (pipe) {
            case "-" : {
                return origin.equals(Direction.EAST) ? Direction.WEST : Direction.EAST;
            }
            case "|" : {
                return origin.equals(Direction.NORTH) ? Direction.SOUTH : Direction.NORTH;
            }
            case "7" : {
                return origin.equals(Direction.WEST) ? Direction.SOUTH : Direction.WEST;
            }
            case "L" : {
                return origin.equals(Direction.NORTH) ? Direction.EAST : Direction.NORTH;
            }
            case "J" : {
                return origin.equals(Direction.NORTH) ? Direction.WEST : Direction.NORTH;
            }
            case "F" : {
                return origin.equals(Direction.SOUTH) ? Direction.EAST : Direction.SOUTH;
            }

        }

        return null;

    }

    public static Direction getOrigin(String pipe, Direction nextDirection) {

        if(nextDirection.equals(Direction.NORTH)) {
            return Direction.SOUTH;
        } else if(nextDirection.equals(Direction.SOUTH)) {
            return Direction.NORTH;
        } else if(nextDirection.equals(Direction.EAST)) {
            return Direction.WEST;
        } else {
            return Direction.EAST;
        }

    }

}
