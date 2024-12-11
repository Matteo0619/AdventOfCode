package adventofcode.y2024.day11;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day11/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<String> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null ) {
           list.addAll(Arrays.asList(line.split(" ")));
        }

        for(int i=0; i<25; i++) {
            for(int j=0; j<list.size(); j++) {
                if(list.get(j).equals("0")) {
                    list.set(j, "1");
                } else if(list.get(j).length() %2 == 0) {
                    String s = list.get(j);
                    int length = s.length();
                    String s1 = StringUtils.stripStart(s.substring(0, length/2), "0");
                    String s2 = StringUtils.stripStart(s.substring(length/2), "0");
                    list.add(j, s1.isEmpty() ? "0" : s1);
                    list.set(j+1, s2.isEmpty() ? "0" : s2);
                    j++;
                } else {
                    Long n = Long.parseLong(list.get(j));
                    list.set(j, "" + n*2024);
                }
            }

            System.out.println(i + ": " + list);
        }

        System.out.print(list.size());

    }

}
