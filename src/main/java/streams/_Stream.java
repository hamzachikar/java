package streams;



import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people =List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Asma", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)

        );

        people.stream()
                .map(person->person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        final Function<Person, String> personStringFunction = person -> person.name;
        final ToIntFunction<String> length = String::length;
        final IntConsumer println = System.out::println;
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        final Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);
        System.out.println(people.stream()
                .allMatch(personPredicate));

    }

    static class Person{

        private final String name;
        private final Gender gender;
        Person(String name,Gender gender){
            this.name=name;
            this.gender=gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE,FEMALE
    }
}
