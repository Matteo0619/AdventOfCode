package adventofcode.y2022.day3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        int total = 0;
        while((line = buffer.readLine()) != null) {
            String[] arr = line.split("");
            List<String> list = new ArrayList<>(Arrays.asList(arr));
            List<String> first = list.subList(0, (list.size())/2);
            List<String> second = list.subList(list.size()/2, list.size());
            System.out.println(arr.toString() + " " + first.toString() + " " + second.toString());

            first.retainAll(second);
            total += count(first.stream().distinct().collect(Collectors.toList()));
        }

        System.out.println(total);
    }

    public static int count(List<String> list) {
        int total = 0;
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> l = Arrays.asList(alph.split(""));

        for(String s : list) {
            total += l.indexOf(s) +1;
        }

        return total;
    }
}
