package adventofcode.y2024.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day9/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = buffer.readLine();
        List<MemoryFile> list = new ArrayList<>();

        Long counter = 0L;
        for(int i=0; i<line.length(); i++) {
            Long c = Long.parseLong(String.valueOf(line.charAt(i)));
            if(c == 0) {
                continue;
            }
            if(i%2 == 0) {
                list.add(new MemoryFile(String.valueOf(counter), c));
                counter ++;
            } else {
                list.add(new MemoryFile(".", c));
            }

        }

        for(int i=list.size()-1; i>=0; i--) {
            MemoryFile v = list.get(i);
            if(v.getValue().equals(".")) {
                continue;
            }
            for(int n=0; n<=i; n++) {
                if(list.get(n).getValue().equals(".")) {
                    MemoryFile v2 = list.get(n);
                    if(v.getOcurrency() > v2.getOcurrency()) {
                        continue;
                    }
                    if(v.getOcurrency().equals(v2.getOcurrency())) {
                        v2.setValue(v.getValue());
                        v.setValue(".");
                        break;
                    } else {
                        list.add(n, new MemoryFile(v.getValue(), v.getOcurrency()));
                        v.setValue(".");
                        v2.setOcurrency(v2.getOcurrency() - v.getOcurrency());
                        i++;
                        break;
                    }
                }
            }

        }

//        for(int i=0; i< list.size(); i++) {
//            MemoryFile v = list.get(i);
//            for(int n=0; n<v.getOcurrency(); n++) {
//                System.out.print(v.getValue() + "");
//            }
//        }

        Long total = 0L;
        int c = 0;
        for(int i=0; i<list.size(); i++) {
            MemoryFile v = list.get(i);
            if(v.getValue().equals(".")) {
                c += v.getOcurrency();
                continue;
            }
            for(int n=0; n<v.getOcurrency(); n++) {
                total += Long.parseLong(v.getValue()) * c;
                c++;
            }
        }

        //7109634074083
        System.out.println(total);

    }

}
