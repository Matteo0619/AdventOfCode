package adventofcode.y2021.day25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    //il problema è evitare di spostare elementi che si è già spostati mentre si scorre l'array

    public static void main(String[] args) throws IOException {
        File file = new File("res/2021/day25/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        List<List<String>> list = new ArrayList<>();

        String line = null;

        while ((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        String[][] arr = list.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);

        int row = arr.length;
        int col = arr[0].length;

        boolean movedR = false;
        boolean movedD = false;
        int counter = 0;

        do {
            for(int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    String s = arr[i][j];
                    switch (s) {
                        case "." :
                        case "v" : {
                            break;
                        }
                        case ">" : {
                            if(j == col-1) {
                                if(arr[i][0].equals(".")){
                                    arr[i][0] = ">";
                                    arr[i][j] = ".";
                                    movedD = true;
                                    break;
                                }
                            } else if(arr[i][j+1].equals(".")) {
                                    arr[i][j+1] = ">";
                                    arr[i][j] = ".";
                                    movedD = true;
                                    j++;
                                    break;
                            }
                            movedD = false;
                        }
                    }
                }
            }

            for(int j=0; j<col; j++) {
                for (int i=0; i<row; i++) {
                    String s = arr[i][j];
                    switch (s) {
                        case "." :
                        case ">" : {
                            break;
                        }
                        case "v" : {
                            if(i == row-1) {
                                if(arr[0][j].equals(".")){
                                    arr[0][j] = "v";
                                    arr[i][j] = ".";
                                    movedR = true;
                                    break;
                                }
                            } else if(arr[i+1][j].equals(".")) {
                                    arr[i+1][j] = "v";
                                    arr[i][j] = ".";
                                    i++;
                                    movedR = true;
                                    break;
                            }
                            movedR = false;
                        }
                    }
                }
            }
            counter++;
        } while (movedD || movedR);

        System.out.println(counter);


    }
}
