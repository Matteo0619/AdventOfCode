package adventofcode.y2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<>(data);
        //child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

}
