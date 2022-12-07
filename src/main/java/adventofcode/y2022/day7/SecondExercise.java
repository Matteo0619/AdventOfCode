package adventofcode.y2022.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day7/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = buffer.readLine();
        String parent = line.replace("$ cd ", "");
        Node<Element> root = new Node<>(new Element(parent, "dir"));
        Node<Element> current = root;
        Node<Element> previus = root;

        while ((line = buffer.readLine()) != null) {
            if(line.contains("$ ls")) {

            } else if(line.contains("dir")) {
                String name = line.replace("dir ", "");
                Node<Element> son = new Node<>(new Element(name, "dir"));
                son.setParent(current);
            } else if(line.contains("$ cd ")) {
                String to = line.replace("$ cd ", "");
                switch (to) {
                    case "/" : {
                        previus = root;
                        current = root;
                        break;
                    }
                    case ".." : {
                        current = previus;
                        previus = current.getParent();
                        break;
                    }
                    default: {
                        previus = current;
                        current = current.getChildren().stream()
                                .filter(c -> c.getData().getName().equals(to))
                                .findFirst().get();
                        break;
                    }
                }
            } else {
                String[] array = line.split(" ");
                int size = Integer.parseInt(array[0]);
                String name = array[1];
                Node<Element> doc = new Node<>(new Element(name, size, "file"));
                doc.setParent(current);
            }
        }

        List<Element> elements = Utility.recursion2(root);

        int sizeRoot = root.getData().getSize();
        int free = 70000000 - sizeRoot;
        int needed = 30000000 - free;

        List<Integer> values = elements.stream().map(Element::getSize).filter(size -> size >= needed).collect(Collectors.toList());
        Collections.sort(values);
        int size = values.get(0);

        System.out.println(size);

    }
}

