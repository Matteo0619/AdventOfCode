package adventofcode.y2024.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day3/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        line = buffer.readLine();

        String regex = "(mul\\(\\d+,\\d+\\))|\\b(do\\(\\))|\\b(don't\\(\\))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        boolean mulEnabled = true;
        int total = 0;

        while (matcher.find()) {
            String match = matcher.group();

            if (match.equals("do()")) {
                mulEnabled = true;
            } else if (match.equals("don't()")) {
                mulEnabled = false;
            } else if (match.startsWith("mul(")) {
                if (mulEnabled) {
                    String numbers = match.substring(4, match.length() - 1);
                    String[] numArray = numbers.split(",");
                    int num1 = Integer.parseInt(numArray[0]);
                    int num2 = Integer.parseInt(numArray[1]);
                    total += num1 * num2;
                }
            }
        }
        System.out.println(total);



    }
}
