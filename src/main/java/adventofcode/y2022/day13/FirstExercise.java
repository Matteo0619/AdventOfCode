package adventofcode.y2022.day13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstExercise {
    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day13/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        Map<Integer, List<String>> map = new HashMap<>();
        int counter = 1;

        String line = null;
        while ((line = buffer.readLine()) != null) {
            List<String> list = new ArrayList<>();
            //line = line.replace(",", "");
            int s = 0;
            int c1 = 0;
            int c2 = 0;
            for(int i=0; i<line.length(); i++) {
                if(line.charAt(i) == '[') {
                    c1++;
                } else if(line.charAt(i) == ']') {
                    c2++;
                }
                if(c1==c2) {
                    list.add(line.substring(s,i+1));
                    s=i+1;
                }
            }
            map.put(counter, list);
            counter++;
        }

        for(String s : map.get(1)) {
            System.out.println(s);
        }

        System.out.println(map.get(1));

    }
}
