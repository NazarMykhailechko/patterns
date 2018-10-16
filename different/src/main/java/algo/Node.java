package algo;

public class Node<T> {

    private Node next;
    private T value;

    public Node() {
    }

    public Node(Node next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
