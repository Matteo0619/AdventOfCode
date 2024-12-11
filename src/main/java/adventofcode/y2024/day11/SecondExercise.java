package adventofcode.y2024.day11;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day11/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        Map<String, Long> map = new HashMap<>();

        while ((line = buffer.readLine()) != null ) {
            String[] arr = line.split(" ");
            for(String s : arr) {
                map.put(s, map.getOrDefault(s, 0L)+1);
            }
        }

        for(int i=0; i<75; i++) {
            Map<String, Long> newMap = new HashMap<>();
            for(String s : map.keySet()) {
                if(s.equals("0")) {
                    newMap.put("1", newMap.getOrDefault("1", 0L)+map.get(s));
                } else if(s.length() %2 == 0) {
                    int length = s.length();
                    String s1 = StringUtils.stripStart(s.substring(0, length/2), "0").isEmpty() ? "0" : StringUtils.stripStart(s.substring(0, length/2), "0");
                    String s2 = StringUtils.stripStart(s.substring(length/2), "0").isEmpty() ? "0" : StringUtils.stripStart(s.substring(length/2), "0");
                    newMap.put(s1, newMap.getOrDefault(s1, 0L)+map.get(s));
                    newMap.put(s2, newMap.getOrDefault(s2, 0L)+map.get(s));
                } else {
                    Long n = Long.parseLong(s) * 2024;
                    newMap.put("" + n, newMap.getOrDefault("" + n, 0L) + map.get(s));
                }
            }

            map = newMap;

        }


        System.out.print(map.values().stream().mapToLong(Long::longValue).sum());

    }
}
