package structures.stack;

import structures.stack.exceptions.EmptyStackException;

public class TestStack {

    public static void main(String[] args) {
        TestPush();
        TestPop();
    }

    private static void TestPush() {
        Stack<Integer> stack = new MyLinckedStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(5);

        System.out.println("TestPush(): " + (stack.getStackSize()==5));
    }

    private static void TestPop() {
        Stack<Integer> stack = new MyLinckedStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(5);

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        System.out.println("TestPop(): " + (stack.getStackSize()==4));

    }

}
