package adventofcode.y2024.day13;

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
        File file = new File("res/2024/day13/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        Long total = 0L;

        while ((line = buffer.readLine()) != null) {
            Long a1 = Long.parseLong(line.replace("Button A: X+", "").split(",")[0]);
            Long a2 = Long.parseLong(line.split(", Y+")[1]);
            line = buffer.readLine();
            Long b1 = Long.parseLong(line.replace("Button B: X+", "").split(",")[0]);
            Long b2 = Long.parseLong(line.split(", Y+")[1]);
            line = buffer.readLine();
            Long tot1 = Long.parseLong(line.replace("Prize: X=", "").split(",")[0])+10000000000000L;
            Long tot2 = Long.parseLong(line.split(", Y=")[1])+10000000000000L;
            line = buffer.readLine();
            Long delta = (a1 * b2) - (a2 * b1);
            Long deltaA = (tot1 * b2) - (tot2 * b1);
            Long deltaB = (a1 * tot2) - (a2 * tot1);
            Long a = deltaA / delta;
            Long b = deltaB / delta;

            if(a1 * a + b1 * b == tot1 && a2*a + b2*b == tot2) {
                total += a*3 + b;
            }

        }


        System.out.print(total);

    }

}
