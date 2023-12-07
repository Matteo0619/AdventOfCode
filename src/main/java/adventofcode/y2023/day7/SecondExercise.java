package adventofcode.y2023.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecondExercise {
    static List<String> strengths = List.of("FIVE", "POKER", "FULL", "TRIS", "DOUBLE PAIR", "PAIR", "HIGH");
    static List<String> cards = List.of("A", "K", "Q", "T", "9", "8", "7", "6", "5", "4", "3", "2", "J");

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day7/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);


        String line = null;
        long total = 0;
        int counter = 1;

        Map<String, Long> map = new HashMap<>();

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split(" ");
            map.put(arr[0], Long.valueOf(arr[1]));

        }

        List<String> hands = new ArrayList<>(map.keySet());

        hands = orderHands(hands.toArray(new String[0]));

        Collections.reverse(hands);

        for(String h : hands) {
            total += counter * map.get(h);
            counter++;
        }

        System.out.println(total);


        //251577888 too low
    }

    public static List<String> orderHands(String[] hands) {
        String[] temp = new String[hands.length];
        boolean found = false;
        int counter = 0;

        for(int i=0; i<hands.length; i++) {
            for(int k=i+1; k< hands.length; k++) {
                String strength1 = calculateStrength(hands[i]);
                String strength2 = calculateStrength(hands[k]);

                if(!isStronger(strength1, hands[i], strength2, hands[k])) {
                    String t = hands[i];
                    hands[i] = hands[k];
                    hands[k] = t;
                }
            }
        }

        return Arrays.asList(hands);

    }

    public static String calculateStrength(String hand) {
        List<String> list = List.of(hand.split(""));
        List<String> copy = new ArrayList<>(list);
        Map<String, Integer> map = new HashMap<>();

        long jolly = Arrays.stream(hand.split("")).filter(e->e.equals("J")).count();

        for(String s : list) {
            if(s.equals("J")) {
                continue;
            }

            long count = copy.stream().filter(e -> e.equals(s)).count();

            if(count <= 1) {
                continue;
            }

            map.put(s, Math.toIntExact(count));

            copy.removeIf(e-> e.equals(s));
        }

        if(map.isEmpty()) {
            return applyJolly("HIGH", jolly);
        } else if (map.size() == 1) {
            if(map.values().stream().findFirst().get() == 2) {
                return applyJolly("PAIR", jolly);
            } else if(map.values().stream().findFirst().get() == 5){
                return applyJolly("FIVE", jolly);
            } else if(map.values().stream().findFirst().get() == 4) {
                return applyJolly("POKER", jolly);
            } else {
                return applyJolly("TRIS", jolly);
            }
        }
        else {
            int n = map.values().stream().mapToInt(Integer::intValue)
                    .sum();
            if(n == 4) {
                return applyJolly("DOUBLE PAIR", jolly);
            } else if(n == 5) {
                return "FULL";
            }
        }

        return "";
    }

    public static boolean isStronger(String s1, String c1, String s2, String c2) {
        if(!s1.equals(s2)) {
            return strengths.indexOf(s1) < strengths.indexOf(s2);
        } else {
            String[] arr1 = c1.split("");
            String[] arr2 = c2.split("");
            for(int i=0; i<arr1.length; i++) {
                if(!arr1[i].equals(arr2[i])) {
                    return cards.indexOf(arr1[i]) < cards.indexOf(arr2[i]);
                }
            }
        }

        return false;
    }

    public static String applyJolly(String strength, long jolly) {

        if(jolly == 0) {
            return strength;
        }

        switch (strength) {
            case "HIGH" : {
                if(jolly == 1) {
                    return "PAIR";
                } else if(jolly == 2) {
                    return "TRIS";
                } else if(jolly == 3) {
                    return "POKER";
                } else {
                    return "FIVE";
                }
            }
            case "PAIR" : {
                if (jolly == 1) {
                    return "TRIS";
                } else if (jolly == 2) {
                    return "POKER";
                } else {
                    return "FIVE";
                }
            }
            case "TRIS" : {
                if (jolly == 1) {
                    return "POKER";
                } else {
                    return "FIVE";
                }
            }
            case "DOUBLE PAIR" : {
                if(jolly == 1) {
                    return "FULL";
                }
                break;
            }
            case "POKER" :
            case "FIVE" : {
                return "FIVE";
            }

        }

        return "";

    }

}
