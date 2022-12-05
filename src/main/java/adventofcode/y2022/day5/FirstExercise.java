package adventofcode.y2022.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day5/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "BGSC");
        map.put("2", "TMWHJNVG");
        map.put("3", "MQS");
        map.put("4", "BSLTWNM");
        map.put("5", "JZFTVGWP");
        map.put("6", "CTBGQHS");
        map.put("7", "TJPBW");
        map.put("8", "GDCZFTQM");
        map.put("9", "NSHBPF");
        HashMap<String, String> copy = new HashMap<>();
        int counter = 0;

        String line = null;

        while((line = buffer.readLine()) != null) {
            line = line.replace("move ", "").replace(" from ", "-").replace(" to ", "-");
            String[] s = line.split("-");
            int i = Integer.parseInt(s[0]);
            for(int c = 0; c<i; c++) {
                String from = map.get(s[1]);
                String to = map.get(s[2]);
                String add = from.substring(from.length()-1);
                to +=add;
                map.put(s[1], from.substring(0, from.length()-1));
                map.put(s[2], to);
            }
        }

        System.out.println(map.toString());
    }
}
