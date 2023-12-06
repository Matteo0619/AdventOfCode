package adventofcode.y2023.day5;

import adventofcode.y2023.day3.Gear;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher("123 456 789");

        matcher.results().forEach(m -> System.out.println(m.group()));

        while((line = buffer.readLine()) != null) {




        }



    }

}
