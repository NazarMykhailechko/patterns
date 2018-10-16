package lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        System.out.println(Arrays.stream("1 2 3 4 5 6 7 8 9 10".split(" ")).mapToInt(Integer::parseInt).sum());

        System.out.println(Stream.of("sgrgre","erwgergg","cvbxcvbcv","wrwtewtwe","rwetweqw")
                .filter(s->s.contains("rw"))
                .map(String::toUpperCase)
                .mapToInt(s->s.charAt(0)).sum());


        List<Person> persons = Arrays.asList(
                 new Person("Nazar",35),
                 new Person("Kolya",34),
                 new Person("Igor",42),
                 new Person("Andy",40),
                 new Person("Olya",51),
                 new Person("Lesya",38),
                 new Person("Kostya",41)
        );

        System.out.println(persons.stream().mapToInt(Person::getAge).max().getAsInt());

        List<String> names = new ArrayList<>();

        names.add("Nazar");
        names.add("Kolya");
        names.add("Igor");
        names.add("Andy");
        names.add("Olya");
        names.add("Lesya");
        names.add("Kostya");

        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + "!!!" + s2;
            }
        };
Function<String, Boolean> fbool = new Function<String, Boolean>() {
    @Override
    public Boolean apply(String s) {
        return s.contains("a");
    }
};

Consumer c = new Consumer() {
    @Override
    public void accept(Object o) {

    }
};

Predicate p = new Predicate() {
    @Override
    public boolean test(Object o) {
        return false;
    }
};

        Stream<String> stream = names.stream().filter(n->n.length()<5);
        stream.forEach(System.out::println);
                //.flatMap(o).ifPresent(System.out::println);
                //.map(String::toUpperCase).ifPresent(System.out::println);
                //.collect(Collectors.joining(", "));

                //.filter(name->name.contains("A"))
                //.forEach(System.out::println);


        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(12);
        numbers.add(15);
        numbers.add(25);
        numbers.add(11);
        numbers.add(43);
        numbers.add(98);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                return 0;
                else
                    return -1;

            }
        };

        int max = numbers.stream()
                .map(num->num*2)
                .map(num->num+3)
                .mapToInt(num->num+3).sum();
 /*               .filter(num->num>50)
                .sorted((n1,n2)->n1>n2?0:-1)
                .max((n1,n2)->n1>n2?0:-1).get()*/

                //.forEach(System.out::println);
        System.out.println(max);
    }
}
