package adventofcode.y2022.day15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day15/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<Sensor> sensorList = new ArrayList<>();
        List<Set<Integer>> matrix = new ArrayList<>();
        int row = 4000000;
        String line = null;
        while ((line = buffer.readLine()) != null) { //Sensor at x=2483411, y=3902983: closest beacon is at x=2289579, y=3633785
            line = line.replace("Sensor at x=", "").replace(", y=", " ").replace(": closest beacon is at x=", " ");
            String[] arr = line.split(" ");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            int x2 = Integer.parseInt(arr[2]);
            int y2 = Integer.parseInt(arr[3]);
            int distanceSB = Math.abs(x1-x2) + Math.abs(y1-y2);

            Sensor sensor = new Sensor(x1, y1, distanceSB);
            sensorList.add(sensor);

        }
        CountDownLatch latch = new CountDownLatch(1);

        for(int i=0; i<4000000; i++) {
            LineHandler handler = new LineHandler(latch, sensorList, i, row);
            handler.start();
            //latch.countDown();

        }


    }

    public static int getMissingNo(int[] nums, int n)
    {
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++)
            sum -= nums[i];
        return sum;
    }
}
