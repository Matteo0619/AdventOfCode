package adventofcode.y2022.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day10/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        int cycle = 0;
        int register = 1;

        List<String> list = new ArrayList<>();
        String line = null;

        while ((line = buffer.readLine()) != null) {
            if(cycle%40 == 0) {
                cycle =0;
            }
            if(line.contains("noop")) {
                if(isOver(register, cycle)) {
                    list.add("#");
                } else {
                    list.add(".");
                }
                cycle++;
            } else {
                int value = Integer.parseInt(line.split(" ")[1]);
                for(int i=0; i<2;i++) {
                    if(isOver(register, cycle)) {
                        list.add("#");
                    } else {
                        list.add(".");
                    }
                    cycle++;
                }
                register += value;
            }
        }
        System.out.println(list.subList(0, 40) + "\n" + list.subList(40, 80) + "\n" + list.subList(80, 120)
                + "\n" + list.subList(120, 160) + "\n" + list.subList(160, 200) + "\n" + list.subList(200, 240));
    }

    private static boolean isOver(int register, int cycle) {
        return register == cycle || register-1 == cycle || register+1 == cycle;
    }

}
