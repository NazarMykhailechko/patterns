package patterns.prototype.advanced;

public class AdvancedPrototypeTest {

    public static void main(String[] args) {

        PersonFactory personFactory = new PersonFactory(new patterns.prototype.advanced.Person("Andy",40));
        patterns.prototype.advanced.Person p3 = personFactory.copyPerson();
        patterns.prototype.advanced.Person p4 = personFactory.copyPerson();
        patterns.prototype.advanced.Person p5 = personFactory.copyPerson();

        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}

interface Prototypable{
    Person copy();
}

class Person implements Prototypable {

    private String name;
    private int age;

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

class PersonFactory{

    patterns.prototype.advanced.Person person;

    public PersonFactory(patterns.prototype.advanced.Person person) {
        this.person = person;
    }

    public patterns.prototype.advanced.Person copyPerson(){
        return person.copy();
    }

}