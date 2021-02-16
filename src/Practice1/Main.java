package Practice1;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final String[] input = {"my@protonmail.su", "a"};

        Predicate<String> check = checkThis -> Pattern.matches(".*@.*", checkThis);
        Arrays.stream(input).filter(check).forEach(System.out::println);
    }
}