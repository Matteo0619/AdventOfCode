package adventofcode.y2023.day8;

import javax.security.auth.callback.TextOutputCallback;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondExercise {


    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day8/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        boolean found = false;
        boolean end;
        long counter = 0;
        BigInteger total = BigInteger.ONE;


        String line = null;
        String[] instructions = buffer.readLine().split("");
        Map<String, Direction> map = new HashMap<>();
        List<Node> startingNodes = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            line = line.replace("(", "").replace(")", "");

            String[] arr = line.split(" = ");
            String[] dir = arr[1].split(", ");

            map.put(arr[0], new Direction(dir[0], dir[1]));

            if(arr[0].endsWith("A")) {
                startingNodes.add(new Node(arr[0], arr[0]));
            }

        }

        for(Node node : startingNodes) {
            while(!found) {
                for(String instruction : instructions) {
                    String current = node.getCurrent();
                    counter++;
                    if (instruction.equals("L")) {
                        current = map.get(current).getLeft();
                    } else {
                        current = map.get(current).getRight();
                    }
                    node.setCurrent(current);
                    if(current.endsWith("Z")) {
                        node.setCounter(counter);
                        found=true;
                        break;
                    }
                }
            }
            counter = 0;
            found = false;
        }

        for(int i=0; i<startingNodes.size(); i++) {
            total = calcolaLCM(total, BigInteger.valueOf(startingNodes.get(i).getCounter()));
        }

        System.out.println(total);


    }

    private static BigInteger calcolaLCM(BigInteger a, BigInteger b) {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        BigInteger gcd = calcolaMCD(a, b);
        return a.multiply(b).abs().divide(gcd);
    }

    private static BigInteger calcolaMCD(BigInteger a, BigInteger b) {
        return a.gcd(b).abs();
    }

}
