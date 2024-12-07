package adventofcode.y2024.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day6/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<String> lines = new ArrayList<>();

        while ((line = buffer.readLine()) != null ) {
            lines.add(line);
        }

        String[][] mat = new String[lines.size()][];

        for(int i=0; i<lines.size(); i++) {
            mat[i] = lines.get(i).split("");
        }

        String nextD = "U";
        boolean finished = false;
        int[] coords = startPoint(mat);

        while(!finished) {
            switch (nextD) {
                case "U" : {
                    System.out.println("U");
                    try {
                        coords = moveUp(mat, coords);
                        nextD = "R";
                        break;
                    } catch (Exception e) {
                        finished = true;
                        break;
                    }

                }
                case "R" : {
                    System.out.println("R");
                    try {
                        coords = moveRight(mat, coords);
                        nextD = "D";
                        break;
                    } catch (Exception e) {
                        finished = true;
                        break;
                    }

                }
                case "D" : {
                    System.out.println("D");
                    try {
                        coords = moveDown(mat, coords);
                        nextD = "L";
                        break;
                    } catch (Exception e) {
                        finished = true;
                        break;
                    }

                }
                case "L" : {
                    System.out.println("L");
                    try {
                        coords = moveLeft(mat, coords);
                        nextD = "U";
                        break;
                    } catch (Exception e) {
                        finished = true;
                        break;
                    }

                }
            }
        }

        int counter = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j].equals("X")) {
                    counter++;
                }
                System.out.print(mat[i][j]);
            }
            System.out.println("\n");
        }

        System.out.println(counter);


    }

    public static int[] startPoint(String[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j].equals("^")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] moveUp(String[][] mat, int[] coords) {
        boolean finished = false;
        int x = coords[0];
        int y = coords[1];
        while (!finished) {
            mat[x][y] = "X";
            String value = mat[x-1][y];
            x--;
            if (value.equals("#")) {
                finished = true;
            }
        }
        return new int[]{x+1, y};
    }

    public static int[] moveRight(String[][] mat, int[] coords) {
        boolean finished = false;
        int x = coords[0];
        int y = coords[1];
        while (!finished) {
            mat[x][y] = "X";
            String value = mat[x][y+1];
            y++;
            if (value.equals("#")) {
                finished = true;
            }
        }
        return new int[]{x, y-1};
    }

    public static int[] moveDown(String[][] mat, int[] coords) {
        boolean finished = false;
        int x = coords[0];
        int y = coords[1];
        while (!finished) {
            mat[x][y] = "X";
            String value = mat[x+1][y];
            x++;
            if (value.equals("#")) {
                finished = true;
            }
        }
        return new int[]{x-1, y};
    }

    public static int[] moveLeft(String[][] mat, int[] coords) {
        boolean finished = false;
        int x = coords[0];
        int y = coords[1];
        while (!finished) {
            mat[x][y] = "X";
            String value = mat[x][y-1];
            y--;
            if (value.equals("#")) {
                finished = true;
            }
        }
        return new int[]{x, y+1};
    }


}
