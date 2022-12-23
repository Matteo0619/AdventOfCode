package adventofcode.y2022.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<Valve> {

    private List<Node<Valve>> children;
    private Node<Valve> parent;
    private Valve data;

    public Node(Valve data) {
        this.children = new ArrayList<>();
        this.data = data;
    }

    public List<Node<Valve>> getChildren() {
        return children;
    }

    public void setParent(Node<Valve> parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public Node<Valve> getParent() {
        return this.parent;
    }

    public void addChild(Valve data) {
        Node<Valve> child = new Node<>(data);
        //child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<Valve> child) {
        this.children.add(child);
    }

    public Valve getData() {
        return this.data;
    }

    public void setData(Valve data) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
