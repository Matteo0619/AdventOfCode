package adventofcode.y2022.day12;

import java.util.concurrent.CountDownLatch;

public class AsyncWorker extends Thread {
    private CountDownLatch latch;
    private Position[][] mat;
    private int srcR;
    private int srcC;
    private int destR;
    private int destC;
    private int min_dist;
    private int dist;

    public AsyncWorker(String name, CountDownLatch latch, Position[][] mat, int srcR, int srcC, int destR, int destC, int min_dist, int dist) {
        this.latch = latch;
        this.mat = mat;
        this.srcR = srcR;
        this.srcC = srcC;
        this.destR = destR;
        this.destC = destC;
        this.min_dist = min_dist;
        this.dist = dist;
        setName(name);
    }

    @Override
    public void run() {
        try {
            latch.await();
            if(this.getName().equals("TOP")) {
                // go to the top cell
                if (FirstExercise.isSafe(mat, srcR - 1, srcC, mat[srcR][srcC].getValue())) {
                    //System.out.println("TOP " + mat[srcR][srcC].getValue() + " TO " + mat[srcR-1][srcC].getValue());
                    min_dist = FirstExercise.findShortestPath(mat, srcR - 1, srcC, destR, destC,
                            min_dist, dist + 1);
                }
            }else if(this.getName().equals("RIGHT")) {
                // go to the right cell
                if (FirstExercise.isSafe(mat, srcR, srcC + 1, mat[srcR][srcC].getValue())) {
                    //System.out.println("RIGHT " + mat[srcR][srcC].getValue() + " TO " + mat[srcR][srcC+1].getValue());
                    min_dist = FirstExercise.findShortestPath(mat, srcR, srcC + 1, destR, destC,
                            min_dist, dist + 1);
                }

            }else if(this.getName().equals("DOWN")) {
                // go to the bottom cell
                if (FirstExercise.isSafe(mat, srcR + 1, srcC, mat[srcR][srcC].getValue())) {
                    //System.out.println("DOWN " + mat[srcR][srcC].getValue() + " TO " + mat[srcR+1][srcC].getValue());
                    min_dist = FirstExercise.findShortestPath(mat, srcR + 1, srcC, destR, destC,
                            min_dist, dist + 1);
                }
            }else if(this.getName().equals("LEFT")) {
                // go to the left cell
                if (FirstExercise.isSafe(mat, srcR, srcC - 1, mat[srcR][srcC].getValue())) {
                    //System.out.println("LEFT " + mat[srcR][srcC].getValue() + " TO " + mat[srcR][srcC-1].getValue());
                    min_dist = FirstExercise.findShortestPath(mat, srcR, srcC - 1, destR, destC,
                            min_dist, dist + 1);
                }
            }
        } catch (InterruptedException e) {
            // handle exception
        }
    }
}
