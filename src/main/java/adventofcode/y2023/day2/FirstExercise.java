package adventofcode.y2023.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        int total = 0;

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split(":");

            int gameID = Integer.parseInt(arr[0].split(" ")[1]);

            String[] sets = arr[1].split("; ");

            boolean playable = true;

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

                if(red > 12 || green > 13 || blue > 14) {
                    playable = false;
                    break;
                }

            }

            if(playable) {
                //System.out.println("GAME ID " + gameID + " IS POSSIBLE");
                total = gameID + total;
            } else {
                System.out.println("GAME ID " + gameID + " IS NOT POSSIBLE");
            }

        }

        System.out.println(total);

    }
}
