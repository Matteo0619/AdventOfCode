package adventofcode.y2023.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int total = 0;


        String line = null;

        while ((line = buffer.readLine()) != null) {
            String[] arr = line.split(": ");

            int gameID = Integer.parseInt(arr[0].split(" ")[1]);

            String[] sets = arr[1].split("; ");

            boolean playable = true;

            int tred = 1;
            int tblue = 1;
            int tgreen = 1;

            for(int i = 0; i<sets.length; i++) {
                String[] colors = sets[i].split(", ");

                int red = 0;
                int blue = 0;
                int green = 0;

                for (String color : colors) {
                    String[] col = color.split(" ");
                    switch (col[1]) {
                        case "red": {
                            red = Integer.parseInt(col[0]);
                            break;
                        }
                        case "blue": {
                            blue = Integer.parseInt(col[0]);
                            break;
                        }
                        case "green": {
                            green = Integer.parseInt(col[0]);
                            break;
                        }

                    }

                }

                if(red>tred) {
                    System.out.println("GAME " + gameID +  " RES FOUND " + red);
                    tred = red;
                }
                if(blue>tblue) {
                    tblue = blue;
                }
                if(green>tgreen) {
                    tgreen = green;
                }

            }

            System.out.println("GAME ID " + gameID + " RED " + tred +  " GREEN " + tgreen + " BLUE " + tblue);

            total += tred*tgreen*tblue;

        }

        System.out.println(total);

    }

}

