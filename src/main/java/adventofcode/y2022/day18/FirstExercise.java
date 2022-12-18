package adventofcode.y2022.day18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstExercise {
    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day18/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        List<Cube> matrix = new ArrayList<>();
        int total = 0;

        String line = null;
        while ((line = buffer.readLine()) != null) {
            String[] arr = line.split(",");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);
            int temp = 6;

            Cube cube = new Cube(x,y,z);
            if(!matrix.isEmpty()) {
                for(Cube c : matrix) {
                    int x2 = c.getX();
                    int y2 = c.getY();
                    int z2 = c.getZ();

                    if(x == x2) {
                        if(!(y != y2 && z != z2)) {
                            if(y == y2 && Math.abs(z - z2)==1) {
                                total--;
                                temp--;
                            } else if(z == z2 && Math.abs(y - y2)==1) {
                                total--;
                                temp--;
                            }
                        }
                    } else if(y == y2) {
                        if(!(x != x2 && z != z2)) {
                            if(x == x2 && Math.abs(z - z2)==1) {
                                total--;
                                temp--;
                            } else if(z == z2 && Math.abs(x - x2)==1) {
                                total--;
                                temp--;
                            }
                        }
                    } else if(z == z2) {
                        if(!(y != y2 && x != x2)) {
                            if(y == y2 && Math.abs(x - x2)==1) {
                                total--;
                                temp--;
                            } else if(x == x2 && Math.abs(y - y2)==1) {
                                total--;
                                temp--;
                            }
                        }
                    }
                }
            }
            total += temp;
            matrix.add(cube);
        }

        System.out.println(total);

    }
}
