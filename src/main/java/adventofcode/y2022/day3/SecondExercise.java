package adventofcode.y2022.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line1 = null;
        String line2 = "";
        String line3 = "";
        int total = 0;
        while((line1 = buffer.readLine()) != null) {
            String[] arr1 = line1.split("");
            String[] arr2 = buffer.readLine().split("");
            String[] arr3 = buffer.readLine().split("");

            List<String> list1 = new ArrayList<>(Arrays.asList(arr1));
            List<String> list2 = new ArrayList<>(Arrays.asList(arr2));
            List<String> list3 = new ArrayList<>(Arrays.asList(arr3));

            list1.retainAll(list2);
            list1.retainAll(list3);
            total += count(list1.stream().distinct().collect(Collectors.toList()));
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
