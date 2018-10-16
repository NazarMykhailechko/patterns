package patterns.prototype;

public class PrototypeTest {

    public static void main(String[] args) {

        Person p = new Person("Nazar",35);
        Person p2 = p.copy();

        System.out.println(p);
        System.out.println(p2);

    }

}

interface Prototypable{
    Person copy();
}

class Person implements Prototypable {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Person copy() {
        return new Person(name,age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

