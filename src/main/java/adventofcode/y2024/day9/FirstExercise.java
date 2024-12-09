package adventofcode.y2024.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day9/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = buffer.readLine();
        List<String> list = new ArrayList<>();
        //2333133121414131402

        int counter = 0;
        for(int i=0; i<line.length(); i++) {
            int c = Integer.parseInt(String.valueOf(line.charAt(i)));
            if(i%2 == 0) {
                for(int n=0; n<c; n++) {
                    list.add(String.valueOf(counter));
                }
                counter ++;
            } else {
                for(int n=0; n<c; n++) {
                    list.add(".");
                }
            }

        }

        for(int i=list.size()-1; i>list.size()/2; i--) {
            String v = list.get(i);
            boolean found = false;
            for(int n=0; n<i; n++) {
                if(list.get(n).equals(".")) {
                    list.set(n, v);
                    list.set(i, ".");
                    found = true;
                    break;
                }
            }
            if(!found) {
                break;
            }

        }

        Long total = 0L;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(".")) {
                break;
            }
            total += Long.parseLong(list.get(i)) * i;
        }

        System.out.print(total);

    }

}
