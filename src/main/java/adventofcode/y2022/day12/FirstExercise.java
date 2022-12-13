package adventofcode.y2022.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        //System.out.println(mat[20][0]);

        //System.out.println(list.get(20).stream().map(Position::getValue).collect(Collectors.toList()));
        //System.out.println(Arrays.deepToString(mat));

        int dist = findShortestPathLength(mat, src, dest);
        if (dist != -1)
            System.out.print("Shortest Path is " + dist);

        else
            System.out.print("Shortest Path doesn't exist");

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
            System.out.println("DEST TROVATA");
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        // set (i, j) cell as visited
        visited[srcR][srcC] = true;
        // go to the right cell
        if (isSafe(mat, srcR, srcC + 1, mat[srcR][srcC].getValue())) {
            System.out.println("RIGHT " + mat[srcR][srcC].getValue() + " TO " + mat[srcR][srcC+1].getValue());
            min_dist = findShortestPath(mat, srcR, srcC + 1, destR, destC,
                    min_dist, dist + 1);
        }
        // go to the top cell
        if (isSafe(mat, srcR - 1, srcC, mat[srcR][srcC].getValue())) {
            System.out.println("TOP " + mat[srcR][srcC].getValue() + " TO " + mat[srcR-1][srcC].getValue());
            min_dist = findShortestPath(mat, srcR - 1, srcC, destR, destC,
                    min_dist, dist + 1);
        }
        // go to the bottom cell
        if (isSafe(mat, srcR + 1, srcC, mat[srcR][srcC].getValue())) {
            System.out.println("DOWN " + mat[srcR][srcC].getValue() + " TO " + mat[srcR+1][srcC].getValue());
            min_dist = findShortestPath(mat, srcR + 1, srcC, destR, destC,
                    min_dist, dist + 1);
        }
        // go to the left cell
        if (isSafe(mat, srcR, srcC - 1, mat[srcR][srcC].getValue())) {
            System.out.println("LEFT " + mat[srcR][srcC].getValue() + " TO " + mat[srcR][srcC-1].getValue());
            min_dist = findShortestPath(mat, srcR, srcC - 1, destR, destC,
                    min_dist, dist + 1);
        }
        // remove (i, j) from the visited matrix
        visited[srcR][srcC] = false;
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
            System.out.println("START");
        }

        if(dest.equals("E")) {
            dest = "z";
        } else if(dest.equals("S")) {
            dest = "a";
        }

        int d = (int)dest.charAt(0);
        int s = (int)src.charAt(0);

        return d <= s + 1;
    }
}
