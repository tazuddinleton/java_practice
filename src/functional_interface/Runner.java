package functional_interface;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;


public class Runner {


    private static final Predicate<Integer> greaterThanTen = (num) -> num > 10;
    private static final BiPredicate<Integer, Integer> areEqual = (num1, num2) -> num1 == num2;

    private static final LongPredicate lp = (long num) -> num > 10;

    private static final Consumer<String> greeter = (name)-> System.out.printf("Hello %s%n", name);

    private static final Function<String, Integer> singleArg = (name) -> 10;
    private static final BiFunction<String, String, Integer> twoArg = (name, addr) -> 10;

    private static final TriFunc<String, String, String, String> threeArg = "%s %s %s"::formatted;

    private static final Comparator<Student> byAge = Comparator.comparing(Student::age);

    public void run() {

    }

    public void sortedByAge() {
        var students = List.of(
                new Student("Student 1", 21),
                new Student("Student 2", 22),
                new Student("Student 2", 12)
        );

        var sorted = students.stream().sorted(byAge.reversed()).toList();
        sorted.forEach(s -> System.out.printf("name: %s, age: %s%n", s.name(), s.age()));
    }
}
