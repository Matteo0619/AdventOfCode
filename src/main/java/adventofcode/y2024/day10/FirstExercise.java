package adventofcode.y2024.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static int total = 0;

    public static Set<Path> paths = new HashSet<>();

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day10/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<List<String>> mat = new ArrayList<>();

        while ((line = buffer.readLine()) != null ) {
            mat.add(Arrays.asList(line.split("")));
        }

        for(int i=0; i<mat.size(); i++) {
            for(int j=0; j<mat.get(i).size(); j++) {
                if(mat.get(i).get(j).equals("0")) {
                    calculateTrail(mat, i, j, 0, i, j);
                }
            }
        }

        System.out.print(paths.size());

    }

    private static void calculateTrail(List<List<String>> mat, int i, int j, int currentValue, int startX, int startY) {
        calculateTrailRic(mat, i, j, currentValue, "U", startX, startY);
        calculateTrailRic(mat, i, j, currentValue, "R", startX, startY);
        calculateTrailRic(mat, i, j, currentValue, "D", startX, startY);
        calculateTrailRic(mat, i, j, currentValue, "L", startX, startY);
    }

    private static void calculateTrailRic(List<List<String>> mat, int i, int j, int currentValue, String direction, int startX, int startY) {
        switch (direction) {
            case "U" : {
                try {
                    int n = Integer.parseInt(mat.get(i-1).get(j));
                    if(n-currentValue == 1) {
                        if(n==9) {
                            paths.add(new Path(startX, startY, i-1, j));
                            total++;
                            return;
                        } else {
                            calculateTrail(mat, i-1, j, n, startX, startY);
                        }
                    }
                } catch (Exception e) {
                    return;
                }
                break;

            }
            case "R" : {
                try {
                    int n = Integer.parseInt(mat.get(i).get(j+1));
                    if(n-currentValue == 1) {
                        if(n==9) {
                            paths.add(new Path(startX, startY, i, j+1));
                            total++;
                            return;
                        } else {
                            calculateTrail(mat, i, j+1, n, startX, startY);
                        }
                    }
                } catch (Exception e) {
                    return;
                }
                break;

            }
            case "D" : {
                try {
                    int n = Integer.parseInt(mat.get(i+1).get(j));
                    if(n-currentValue == 1) {
                        if(n==9) {
                            paths.add(new Path(startX, startY, i+1, j));
                            total++;
                            return;
                        } else {
                            calculateTrail(mat, i+1, j, n, startX, startY);
                        }
                    }
                } catch (Exception e) {
                    return;
                }
                break;

            }
            case "L" : {
                try {
                    int n = Integer.parseInt(mat.get(i).get(j-1));
                    if(n-currentValue == 1) {
                        if(n==9) {
                            paths.add(new Path(startX, startY, i, j-1));
                            total++;
                            return;
                        } else {
                            calculateTrail(mat, i, j-1, n, startX, startY);
                        }
                    }
                } catch (Exception e) {
                    return;
                }
                break;

            }
        }
    }

}
