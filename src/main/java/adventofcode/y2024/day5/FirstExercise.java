package adventofcode.y2024.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day5/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<String> rules = new ArrayList<>();
        List<String> pages = new ArrayList<>();

        boolean next = false;

        while ((line = buffer.readLine()) != null ) {
            if(line.equals("")) {
                next = true;
                continue;
            }
            if(!next) {
                rules.add(line);
            } else {
                pages.add(line);
            }
        }


        List<String> corrects = new ArrayList<>();

        for(String p : pages) {
            boolean ok = true;
            for(String  r : rules) {
                String[] arr = r.split("\\|");

                int i1 = p.indexOf(arr[0]);
                int i2 = p.indexOf(arr[1]);

                if(i1 != -1 && i2 != -1 && !(i1 < i2)) {
                    ok = false;
                    break;
                }

            }
            if(ok) {
                corrects.add(p);
            }
        }

        int total = 0;
        for(String s : corrects) {
            String[] arr = s.split(",");
            List<String> values = new ArrayList<>(List.of(arr));
            total += Integer.parseInt(values.get(arr.length / 2));
        }

        System.out.println(total);



    }


}
