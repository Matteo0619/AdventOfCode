package adventofcode.y2022.day16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FirstExercise {

    //public static int maxPressure = 0;

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day16/test.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        Set<Node<Valve>> list = new HashSet<>();
        String line = null;
        int min = 30;
        int maxpressure = 0;

        while ((line = buffer.readLine()) != null) {
            String[] arr = line.split(" ");
            String name = arr[1];
            int rate = Integer.parseInt(arr[4].replace("rate=", "").replace(";", ""));

            Valve valve = new Valve(name, rate);

            Node<Valve> node = list.stream().filter(x ->
                x.getData().getName().equals(name)).findAny().orElse(new Node<>(valve));
            node.getData().setRate(rate);
            list.add(node);

            for (int i = 9; i < arr.length; i++) {
                String s = arr[i].replace(",", "");
                Valve v = new Valve(s);
                Node<Valve> n = list.stream().filter(x ->
                        x.getData().getName().equals(s)).findAny().orElse(new Node<>(v));
                node.addChild(n);
                list.add(n);
            }
        }

        int temp = 0;

        for(Node<Valve> node : list) {
            temp++;
            System.out.println(temp);
            List<Valve> opened = new ArrayList<>();
            int rate1 = 0;
            int prod = node.getData().getRate();

            //apro la valbola se rate != 0
            if(prod != 0) {
                opened.add(node.getData());
                rate1 = calculateRate(node, 27, prod, prod, opened);
            }

            //lascio la valvola chiusa
            int rate2 = calculateRate(node, 28, prod, prod, opened);

            maxpressure = Math.max(maxpressure, Math.max(rate1, rate2));
        }

        System.out.println(maxpressure);


    }

    public static int calculateRate(Node<Valve> node, int min, int prod, int pressure, List<Valve> opened) {

        if(min <= 0) {
            return pressure;
        }

        int temp = 0;

        for(Node<Valve> n : node.getChildren()) {
            int rate1 = 0;
            int rate2;
            int p = n.getData().getRate();
            int pr = prod;

            //apro la valbola se rate != 0
            if(p != 0 && !opened.contains(node.getData())) {
                opened.add(node.getData());
                prod += p;
                rate1 = calculateRate(n, min-2, prod, pressure+prod+pr, opened);
            }

            //lascio la valvola chiusa
            rate2 = calculateRate(n, min-1, prod, pressure+prod, opened);


            temp = Math.max(temp, Math.max(rate1, rate2));

        }

        return temp;
    }


}


