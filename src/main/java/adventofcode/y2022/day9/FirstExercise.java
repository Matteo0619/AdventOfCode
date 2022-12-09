package adventofcode.y2022.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day9/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        int iter = 0;

        Rope head = new Rope();
        Rope tail = new Rope();

        Set<Rope> set = new HashSet<>();

        while((line = buffer.readLine()) != null) {
            iter++;
            String[] input = line.split(" ");
            String move = input[0];
            int count = Integer.parseInt(input[1]);

            switch (move) {
                case "R" : {
                    for(int i=0; i<count; i++) {
                        head.addLength();
                        if(head.isTouching(tail)) {

                        }else if(!head.sameColumn(tail) && !head.sameLine(tail)) {
                            if(head.getHeight() > tail.getHeight()) {
                                tail.addHeight();
                                tail.addLength();
                            } else {
                                tail.removeHeight();
                                tail.addLength();
                            }
                        } else if (head.sameLine(tail)) {
                            tail.addLength();
                        }
                        set.add(new Rope(tail.getHeight(), tail.getLength()));
                    }
                    break;
                }
                case "L" : {
                    for(int i=0; i<count; i++) {
                        head.removeLength();
                        if(head.isTouching(tail)) {

                        }else if(!head.sameColumn(tail) && !head.sameLine(tail)) {
                            if(head.getHeight() > tail.getHeight()) {
                                tail.addHeight();
                                tail.removeLength();
                            } else {
                                tail.removeHeight();
                                tail.removeLength();
                            }
                        } else if (head.sameLine(tail)) {
                            tail.removeLength();
                        }
                        set.add(new Rope(tail.getHeight(), tail.getLength()));
                    }
                    break;
                }
                case "U" : {
                    for(int i=0; i<count; i++) {
                        head.addHeight();
                        if(head.isTouching(tail)) {

                        }else if(!head.sameColumn(tail) && !head.sameLine(tail)) {
                            if(head.getLength() > tail.getLength()) {
                                tail.addHeight();
                                tail.addLength();
                            } else {
                                tail.addHeight();
                                tail.removeLength();
                            }
                        } else if (head.sameColumn(tail)) {
                            tail.addHeight();
                        }
                        set.add(new Rope(tail.getHeight(), tail.getLength()));
                    }
                    break;
                }
                case "D" : {
                    for(int i=0; i<count; i++) {
                        head.removeHeight();
                        if(head.isTouching(tail)) {

                        }else if(!head.sameColumn(tail) && !head.sameLine(tail)) {
                            if(head.getLength() > tail.getLength()) {
                                tail.removeHeight();
                                tail.addLength();
                            } else {
                                tail.removeHeight();
                                tail.removeLength();
                            }
                        } else if (head.sameColumn(tail)) {
                            tail.removeHeight();
                        }
                        set.add(new Rope(tail.getHeight(), tail.getLength()));
                    }
                    break;
                }
            }
        }

        System.out.println(set.size());
    }
}
