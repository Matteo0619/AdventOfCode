package adventofcode.y2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static List<Element> list = new ArrayList<>();

    public static List<Element> recursion(Node<Element> node) {

        if(node.isRoot() && node.getChildren().size() == 0) {
            return list;
        } else if(node.isLeaf()) {
            int size = node.getData().getSize();
            Node<Element> parent = node.getParent();
            parent.getData().addSize(size);
            if(node.getData().isDirectory() && size <= 100000) {
                list.add(node.getData());
            }
            parent.getChildren().remove(node);
            recursion(parent);
        } else {
            if(node.getChildren().size() != 0) {
                recursion(node.getChildren().get(0));
            }
        }

        return list;

    }

    public static List<Element> recursion2(Node<Element> node) {

        if(node.isRoot() && node.getChildren().size() == 0) {
            return list;
        } else if(node.isLeaf()) {
            int size = node.getData().getSize();
            Node<Element> parent = node.getParent();
            parent.getData().addSize(size);
            if(node.getData().isDirectory()) {
                list.add(node.getData());
            }
            parent.getChildren().remove(node);
            recursion2(parent);
        } else {
            if(node.getChildren().size() != 0) {
                recursion2(node.getChildren().get(0));
            }
        }

        return list;

    }


}
