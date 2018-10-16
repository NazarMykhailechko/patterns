package structures.stack;

import structures.Node;
import java.util.EmptyStackException;

public class MyLinckedStack<T> implements Stack<T> {

    private Node head;
    private T value;
    private long size;

    public MyLinckedStack() {
    }

    @Override
    public void push(T t) {
        head = new Node(head);
        this.value = t;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        T element = this.value;
        this.head = head.getNode();
        size--;
        return element;
    }

    @Override
    public long getStackSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinckedStack{" +
                "head=" + head +
                ", value=" + value +
                '}';
    }
}
