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
                new Person("John", Gender.MALE, 12),
                new Person("Maria", Gender.FEMALE, 20),
                new Person("Asma", Gender.FEMALE, 30),
                new Person("Alex", Gender.MALE, 60),
                new Person("Alice", Gender.FEMALE,8)

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
       /* System.out.println(people.stream()
                .allMatch(personPredicate));*/

        final Predicate<Person> personMale = person->person.gender.equals(Gender.MALE);
        List<String>maleNames=people.stream().filter(personMale).map(Person::getName).collect(Collectors.toList());
        maleNames.forEach(System.out::println);

    }

    static class Person{

        private final String name;
        private final Gender gender;
        private final int age;
        Person(String name,Gender gender,int age){
            this.name=name;
            this.gender=gender;
            this.age=age;
        }
        public String getName(){
            return this.name;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +'\'' +
                    ", age=" + age +
                    '}';
        }
    }
    enum Gender{
        MALE,FEMALE
    }
}
