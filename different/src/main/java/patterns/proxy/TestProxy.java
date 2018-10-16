package patterns.proxy;

public class TestProxy {

    public static void main(String[] args) {
        Operation operation = UserFactory.create();
        operation.login("Nazar007");
    }

}

interface Operation {
    void login(String name);
}

class User implements Operation {

    @Override
    public void login(String name) {

        if (name.equals("Nazar007")) {
            System.out.println("success!");
        } else {
            System.out.println("error!");
        }
    }
}

class UserProxy implements Operation {

    private Operation operation;

    public UserProxy(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void login(String name) {

        if (name.length() < 8) {
            System.out.println("too short login!");
        } else {
            operation.login(name);
        }
    }
}

class UserFactory {
    public static Operation create() {
        return new UserProxy(new User());
    }
}

