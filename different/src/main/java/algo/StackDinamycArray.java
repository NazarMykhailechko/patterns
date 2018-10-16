package algo;

public class StackDinamycArray<T> implements IStack<T> {

    private Node next;
    private int index;

    @Override
    public IStack<T> push(T t) {
        Node curr = next;
        next = new Node();

        //next.setNext(t);
        return null;
    }

    @Override
    public T pop(T t) {
        return null;
    }
}
