package structures.stack;

import structures.stack.exceptions.EmptyStackException;

public interface Stack<T> {
    void push(T t);
    T pop() throws EmptyStackException;
    long getStackSize();
}
