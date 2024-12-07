package adventofcode.y2024.day5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day5/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<String> rules = new ArrayList<>();
        List<String> pages = new ArrayList<>();

        boolean next = false;

        while ((line = buffer.readLine()) != null ) {
            if(line.equals("")) {
                next = true;
                continue;
            }
            if(!next) {
                rules.add(line);
            } else {
                pages.add(line);
            }
        }


        List<List<Integer>> incorrects = new ArrayList<>();

        for(String p : pages) {
            boolean ok = true;
            for(String  r : rules) {
                String[] arr = r.split("\\|");

                int i1 = p.indexOf(arr[0]);
                int i2 = p.indexOf(arr[1]);

                if(i1 != -1 && i2 != -1 && !(i1 < i2)) {
                    ok = false;
                    break;
                }

            }
            if(!ok) {
                incorrects.add(Arrays.stream(p.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        int total = 0;

        for (List<Integer> numbers : incorrects) {
            List<Integer> orderedList = orderList(numbers, rules);
            total += orderedList.get(orderedList.size()/2);
        }

        System.out.println(total);
    }

    private static List<Integer> orderList(List<Integer> numbers, List<String> rules) {

        Map<Integer, List<Integer>> grafo = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int numero : numbers) {
            grafo.putIfAbsent(numero, new ArrayList<>());
            indegree.putIfAbsent(numero, 0);
        }

        rules.forEach(r -> {
            String[] arr = r.split("\\|");
            addRule(grafo, indegree, Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        });

        return orderAlgorithm(grafo, indegree);
    }

    private static void addRule(Map<Integer, List<Integer>> grafo, Map<Integer, Integer> indegree, int a, int b) {

        if(grafo.get(a) != null && indegree.get(b) != null) {
            grafo.get(a).add(b);
            indegree.put(b, indegree.get(b) + 1);
        }

    }

    private static List<Integer> orderAlgorithm(Map<Integer, List<Integer>> grafo, Map<Integer, Integer> indegree) {
        List<Integer> ordinamento = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int node : grafo.keySet()) {
            indegree.putIfAbsent(node, 0);
        }

        for (int node : grafo.keySet()) {
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ordinamento.add(node);

            for (int number : grafo.getOrDefault(node, new ArrayList<>())) {
                indegree.put(number, indegree.get(number) - 1);
                if (indegree.get(number) == 0) {
                    queue.add(number);
                }
            }
        }

        return ordinamento;
    }

}
