package Practice2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Practice2 {

    public static void main(String[] args) {
        Human[] human = new Human[5];
        human[0] = new Human(3, "Bxris", "Canthit", LocalDate.of(2000, 1,26), 5);
        human[1] = new Human(20, "Sdrib", "Gothit", LocalDate.of(2013, 10, 10), 63);
        human[2] = new Human(12, "Name", "Surname", LocalDate.of(1900, 1, 3), 40);
        human[3] = new Human(122, "Who", "Asked", LocalDate.of(2579, 12, 1), 58);
        human[4] = new Human(35, "Meh", "Boring", LocalDate.of(1456, 3, 4), 55);

        System.out.println("Part 1. Reverse sort by 2nd char of name:");
        Stream<Human> stream = Arrays.stream(human);
        stream.sorted(Comparator.comparingInt((Human h) -> h.getFirstName().charAt(1)).reversed()).forEach(System.out::println);

        System.out.println("\nPart 2. Weighs more than 60kg:");
        Stream<Human> stream1 = Arrays.stream(human);
        stream1.filter(human1 -> human1.getWeight() > 60).forEach(System.out::println);

        System.out.println("\nPart 3. Age sort:");
        Stream<Human> stream2 = Arrays.stream(human);
        stream2.sorted(Comparator.comparingInt((Human h) -> h.getAge())).forEach(System.out::println);

        System.out.println("\nPart 4. Multiply all ages:");
        Stream<Human> stream3 = Arrays.stream(human);
        System.out.println(stream3.mapToInt(Human::getAge).reduce((a, b) -> a * b).orElse(0));
    }
}