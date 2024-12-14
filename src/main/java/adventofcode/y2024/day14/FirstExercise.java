package adventofcode.y2024.day14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day14/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<Robot> robots = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            line = line.replace("p=", "").replace("v=", "");
            String[] arr = line.split(" ");
            int x = Integer.parseInt(arr[0].split(",")[0]);
            int y = Integer.parseInt(arr[0].split(",")[1]);
            int vx = Integer.parseInt(arr[1].split(",")[0]);
            int vy = Integer.parseInt(arr[1].split(",")[1]);

            robots.add(new Robot(x, y, vx, vy));
        }


        int height = 102;
        int width = 100;

        for(int i=0; i<100; i++) {
            for(Robot robot : robots) {
                int x = robot.getX();
                int y = robot.getY();
                int vx = robot.getVx();
                int vy = robot.getVy();

                if(vx >= 0) {
                    if(x + vx <= width) {
                        robot.setX(x+vx);
                    } else {
                        robot.setX((x+vx)-width-1);
                    }
                } else {
                    if(x + vx >= 0) {
                        robot.setX(x+vx);
                    } else {
                        robot.setX(width+(x+vx)+1);
                    }
                }

                if(vy >= 0) {
                    if(y + vy <= height) {
                        robot.setY(y+vy);
                    } else {
                        robot.setY((y+vy)-height-1);
                    }
                } else {
                    if(y + vy >= 0) {
                        robot.setY(y+vy);
                    } else {
                        robot.setY(height+(y+vy)+1);
                    }
                }


            }
        }

        int q1= 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;

        List<List<String>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));
        mat.add(new ArrayList<>(Arrays.asList("#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#" )));
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));
        mat.add(new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", "#", ".", ".", ".", ".", "." )));

        for(Robot r : robots) {
//            if(mat.get(r.getY()).get(r.getX()).equals("#")) {
//                continue;
//            }
//            if(mat.get(r.getY()).get(r.getX()).equals(".")) {
//                mat.get(r.getY()).set(r.getX(), "1");
//            } else {
//                mat.get(r.getY()).set(r.getX(), Integer.parseInt(mat.get(r.getY()).get(r.getX())) + 1 + "");
//            }
            if(r.getX() >= 0 && r.getX() < width/2 && r.getY() >= 0 && r.getY() < height/2) {
                q1++;
            } else if(r.getX() > width/2 && r.getX() <= width && r.getY() >= 0 && r.getY() < height/2) {
                q2++;
            } else if(r.getX() >= 0 && r.getX() < width/2 && r.getY() > height/2 && r.getY() <= height) {
                q3++;
            } else if(r.getX() > width/2 && r.getX() <= width && r.getY() > height/2 && r.getY() <= height) {
                q4++;
            }

        }


        //142377312 too low
        for(List<String> l : mat) {
            System.out.println(l);
        }
        System.out.print(q1*q2*q3*q4);

    }

}
