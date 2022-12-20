package adventofcode.y2022.day15;

import adventofcode.y2022.day12.FirstExercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class LineHandler extends Thread {

    private CountDownLatch latch;
    private List<Sensor> sensorList;
    private int i;
    private int row;

    public LineHandler(CountDownLatch latch, List<Sensor> sensorList, int i, int row) {
        this.latch = latch;
        this.sensorList = sensorList;
        this.i = i;
        this.row = row;
    }

    @Override
    public void run() {
        try {
            System.out.println(i);
            Set<Integer> set = new HashSet<>();
            for (Sensor sensor : sensorList) {
                int x = sensor.getX();
                int y = sensor.getY();
                int distB = sensor.getDistanceB();
                int distL = Math.abs(y - i);
                int diff = distB - distL;

                if (distL > distB) {
                    continue;
                }

                int start = Math.max(x - diff, 0);
                int end = Math.min(x + diff, row);

                for (int j = start; j <= end; j++) {
                    set.add(j);
                }
            }
            if (set.size() < 4000001) {
                System.out.println(i);
                //System.out.println(set);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
