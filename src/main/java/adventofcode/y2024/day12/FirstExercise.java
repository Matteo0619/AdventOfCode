package adventofcode.y2024.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day12/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        List<List<String>> list = new ArrayList<>();
        List<Position> visited = new ArrayList<>();
        List<List<Position>> regions = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            list.add(Arrays.asList(line.split("")));
        }

        for(int x=0; x<list.size(); x++) {
            for(int y=0; y<list.get(x).size(); y++) {
                if(visited.contains(new Position(x, y))) {
                    continue;
                }
                List<Position> area = new ArrayList<>();
                checkArea(list, visited, area, x, y);
                regions.add(area);
            }
        }

        int total = 0;
        for(List<Position> region : regions) {
            int area = region.size();
            int perimeter = 0;
            for(Position pos : region) {
                int x = pos.getX();
                int y = pos.getY();
                String s = list.get(x).get(y);
                if(checkPerimeter(list, s, x-1, y)) {
                    perimeter++;
                }
                if(checkPerimeter(list, s, x+1, y)) {
                    perimeter++;
                }
                if(checkPerimeter(list, s, x, y+1)) {
                    perimeter++;
                }
                if(checkPerimeter(list, s, x, y-1)) {
                    perimeter++;
                }
            }
            total += area * perimeter;
        }

        System.out.print(total);

    }

    private static boolean checkPerimeter(List<List<String>> list, String s, int x, int y) {
        try {
            return !list.get(x).get(y).equals(s);
        } catch (Exception e) {
            return true;
        }
    }

    private static void checkArea(List<List<String>> list, List<Position> visited, List<Position> area, int currentX, int currentY) {
        if(visited.contains(new Position(currentX, currentY))) {
            return;
        }
        visited.add(new Position(currentX, currentY));
        area.add(new Position(currentX,currentY));
        checkAreaU(list, visited, area, currentX, currentY);
        checkAreaR(list, visited, area, currentX, currentY);
        checkAreaD(list, visited, area, currentX, currentY);
        checkAreaL(list, visited, area, currentX, currentY);
    }

    private static void checkAreaU(List<List<String>> list, List<Position> visited, List<Position> area, int currentX, int currentY) {
        String s = list.get(currentX).get(currentY);

        try {
            String s2 = list.get(currentX-1).get(currentY);
            if(s.equals(s2)) {
                checkArea(list, visited, area, currentX-1, currentY);
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void checkAreaR(List<List<String>> list, List<Position> visited, List<Position> area, int currentX, int currentY) {
        String s = list.get(currentX).get(currentY);

        try {
            String s2 = list.get(currentX).get(currentY+1);
            if(s.equals(s2)) {
                checkArea(list, visited, area, currentX, currentY+1);
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void checkAreaD(List<List<String>> list, List<Position> visited, List<Position> area, int currentX, int currentY) {
        String s = list.get(currentX).get(currentY);

        try {
            String s2 = list.get(currentX+1).get(currentY);
            if(s.equals(s2)) {
                checkArea(list, visited, area, currentX+1, currentY);
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void checkAreaL(List<List<String>> list, List<Position> visited, List<Position> area, int currentX, int currentY) {
        String s = list.get(currentX).get(currentY);

        try {
            String s2 = list.get(currentX).get(currentY-1);
            if(s.equals(s2)) {
                checkArea(list, visited, area, currentX, currentY-1);
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

}
