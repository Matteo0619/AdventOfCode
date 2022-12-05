package adventofcode.y2022.day5;

import java.io.*;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day5/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<String> a = new ArrayList<>(Arrays.asList("B", "G", "S", "C"));
        List<String> b = new ArrayList<>(Arrays.asList("T", "M", "W", "H", "J", "N", "V", "G"));
        List<String> c = new ArrayList<>(Arrays.asList("M", "Q", "S"));
        List<String> d = new ArrayList<>(Arrays.asList("B", "S", "L", "T", "W", "N", "M"));
        List<String> e = new ArrayList<>(Arrays.asList("J", "Z", "F", "T", "V", "G", "W", "P"));
        List<String> f = new ArrayList<>(Arrays.asList("C", "T", "B", "G", "Q", "H", "S"));
        List<String> g = new ArrayList<>(Arrays.asList("T", "J", "P", "B", "W"));
        List<String> h = new ArrayList<>(Arrays.asList("G", "D", "C", "Z", "F", "T", "Q", "M"));
        List<String> i = new ArrayList<>(Arrays.asList("N", "S", "H", "B", "P", "F"));
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("1", a);
        map.put("2", b);
        map.put("3", c);
        map.put("4", d);
        map.put("5", e);
        map.put("6", f);
        map.put("7", g);
        map.put("8", h);
        map.put("9", i);
        HashMap<String, List<String>> copy = new HashMap<>();

        String line = null;

        while((line = buffer.readLine()) != null) {
            line = line.replace("move ", "").replace(" from ", "-").replace(" to ", "-");
            String[] s = line.split("-");
            copy.putAll(map);
            List<String> from = copy.get(s[1]);
            List<String> add = from.subList(from.size() - (Integer.parseInt(s[0])), from.size());
            List<String> remove = from.subList(0, from.size() - (Integer.parseInt(s[0])));
            map.get(s[2]).addAll(add);
            map.put(s[1], remove);
        }

        System.out.println(map.toString());

    }
}
