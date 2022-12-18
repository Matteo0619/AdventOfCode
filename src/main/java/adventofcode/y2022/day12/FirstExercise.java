package adventofcode.y2022.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class FirstExercise {
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day12/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<List<Position>> list = new ArrayList<>();
        String line = null;
        int row = 0;
        int[] src = new int[2];
        int[] dest = new int[2];

        while((line = buffer.readLine()) != null) {

            List<Position> pos = new ArrayList<>();

            String[] arr = line.split("");
            for(int i=0; i<arr.length; i++) {
                String value = arr[i];
                if(value.equals("S")) {
                    src[0] = row;
                    src[1] = i;
                }
                if(value.equals("E")) {
                    dest[0] = row;
                    dest[1] = i;
                }
                pos.add(new Position(row, i, value));
            }
            list.add(pos);
            row++;
        }

        Position[][] mat = list.stream()
                .map(l -> l.toArray(Position[]::new))
                .toArray(Position[][]::new);


        int dist = findShortestPathLength(mat, src, dest);
        if (dist != -1)
            System.out.println("Shortest Path is " + dist);

        else
            System.out.println("Shortest Path doesn't exist");

    }

    static int findShortestPathLength(Position[][] mat, int[] src, int[] dest) {

        int row = mat.length;
        int col = mat[0].length;

        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                visited[i][j] = false;
        }


        int dist = Integer.MAX_VALUE;
        dist = findShortestPath(mat, src[0], src[1], dest[0], dest[1], dist, 0);

        if (dist != Integer.MAX_VALUE)
            return dist;
        return -1;
    }

    static int findShortestPath(Position[][] mat, int srcR, int srcC, int destR, int destC, int min_dist, int dist) {

        if (srcR == destR && srcC == destC) {
            System.out.println("DEST TROVATA " + dist);
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        // set (i, j) cell as visited
        visited[srcR][srcC] = true;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CountDownLatch latch = new CountDownLatch(1);

        AsyncWorker workerT = new AsyncWorker("TOP", latch, mat, srcR, srcC, destR, destC, min_dist, dist);
        AsyncWorker workerR = new AsyncWorker("RIGHT", latch, mat, srcR, srcC, destR, destC, min_dist, dist);
        AsyncWorker workerD = new AsyncWorker("DOWN", latch, mat, srcR, srcC, destR, destC, min_dist, dist);
        AsyncWorker workerL = new AsyncWorker("LEFT", latch, mat, srcR, srcC, destR, destC, min_dist, dist);

        workerL.start();
        workerT.start();
        workerR.start();
        workerD.start();

        latch.countDown();

        return min_dist;

    }

    static boolean isSafe(Position[][] mat, int x, int y, String src) {
        if(!(x >= 0 && x < mat.length)) {
            return false;
        }

        if(!(y >= 0 && y < mat[0].length)) {
            return false;
        }

        if(visited[x][y]) {
            return false;
        }

        String dest = mat[x][y].getValue();
        if(src.equals("S")) {
            src = "a";
        }

        if(dest.equals("E")) {
            dest = "z";
        }

        int d = (int)dest.charAt(0);
        int s = (int)src.charAt(0);

        return  d <= s + 1 ;
    }
}
