package adventofcode.y2022.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day9/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        Rope head = new Rope();
        List<Rope> list = new ArrayList<>(Arrays.asList(new Rope(), new Rope(), new Rope(), new Rope(), new Rope(), new Rope(), new Rope(), new Rope(), new Rope()));

        Set<Rope> set = new HashSet<>();

        while((line = buffer.readLine()) != null) {
            String[] input = line.split(" ");
            String move = input[0];
            int count = Integer.parseInt(input[1]);

            switch (move) {
                case "R" : {
                    for(int c=0; c<count; c++) {
                        head.addLength();
                        for(int i=0; i<list.size(); i++) {
                            Rope temp = i==0 ? head : list.get(i-1);
                            Rope tail = list.get(i);
                            if(temp.isTouching(tail)) {

                            }else if(!temp.sameColumn(tail) && !temp.sameLine(tail)) {
                                handleDiagonal(temp, tail);
                            } else if (temp.sameLine(tail)) {
                                handleSameLine(temp, tail);
                            } else if(temp.sameColumn(tail)) {
                                handleSameColumn(temp, tail);
                            }
                            if(i == list.size()-1) {
                                set.add(new Rope(tail.getHeight(), tail.getLength()));
                            }
                        }
                    }
                    break;
                }
                case "L" : {
                    for(int c=0; c<count; c++) {
                        head.removeLength();
                        for(int i=0; i<list.size(); i++) {
                            Rope temp = i==0 ? head : list.get(i-1);
                            Rope tail = list.get(i);
                            if(temp.isTouching(tail)) {

                            }else if(!temp.sameColumn(tail) && !temp.sameLine(tail)) {
                                handleDiagonal(temp, tail);
                            } else if (temp.sameLine(tail)) {
                                handleSameLine(temp, tail);
                            } else if(temp.sameColumn(tail)) {
                                handleSameColumn(temp, tail);
                            }
                            if(i == list.size()-1) {
                                set.add(new Rope(tail.getHeight(), tail.getLength()));
                            }
                        }
                    }
                    break;
                }
                case "U" : {
                    for(int c=0; c<count; c++) {
                        head.addHeight();
                        for(int i=0; i<list.size(); i++) {
                            Rope temp = i==0 ? head : list.get(i-1);
                            Rope tail = list.get(i);
                            if(temp.isTouching(tail)) {

                            }else if(!temp.sameColumn(tail) && !temp.sameLine(tail)) {
                                handleDiagonal(temp, tail);
                            } else if (temp.sameLine(tail)) {
                                handleSameLine(temp, tail);
                            } else if(temp.sameColumn(tail)) {
                                handleSameColumn(temp, tail);
                            }
                            if(i == list.size()-1) {
                                set.add(new Rope(tail.getHeight(), tail.getLength()));
                            }
                        }
                    }
                    break;
                }
                case "D" : {
                    for(int c=0; c<count; c++) {
                        head.removeHeight();
                        for(int i=0; i<list.size(); i++) {
                            Rope temp = i==0 ? head : list.get(i-1);
                            Rope tail = list.get(i);
                            if(temp.isTouching(tail)) {

                            }else if(!temp.sameColumn(tail) && !temp.sameLine(tail)) {
                                handleDiagonal(temp, tail);
                            } else if (temp.sameLine(tail)) {
                                handleSameLine(temp, tail);
                            } else if(temp.sameColumn(tail)) {
                                handleSameColumn(temp, tail);
                            }
                            if(i == list.size()-1) {
                                set.add(new Rope(tail.getHeight(), tail.getLength()));
                            }
                        }
                    }
                    break;
                }
            }
        }

        System.out.println(set.size());

    }

    private static void handleSameLine(Rope temp, Rope tail) {
        if(tail.getLength() < temp.getLength()) {
            tail.addLength();
        } else {
            tail.removeLength();
        }
    }

    private static void handleSameColumn(Rope temp, Rope tail) {
        if(tail.getHeight() < temp.getHeight()) {
            tail.addHeight();
        } else {
            tail.removeHeight();
        }
    }

    private static void handleDiagonal(Rope temp, Rope tail) {
        if(temp.isUpLeft(tail)) {
            tail.addHeight();
            tail.removeLength();
        } else if(temp.isUpRight(tail)) {
            tail.addHeight();
            tail.addLength();
        } else if(temp.isdDownLeft(tail)) {
            tail.removeHeight();
            tail.removeLength();
        } else if(temp.isDownRight(tail)) {
            tail.removeHeight();
            tail.addLength();
        }
    }
}
