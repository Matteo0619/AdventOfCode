package adventofcode.y2024.day3;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        line = buffer.readLine();

        String regex = "mul\\(\\d+,\\d+\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }
        Long total = 0L;

        for(String s : matches) {
            s = s.replace("mul(", "").replace(")", "");

            String[] arr = s.split(",");
            total += Long.parseLong(arr[0]) * Long.parseLong(arr[1]);
        }

        System.out.println(total);



    }


}
