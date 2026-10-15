
import java.util.Objects;
import java.util.Optional;

class Utility {

    // 1. Check whether two objects are equal
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    // 2. Return value or default
    public static <T> T getDefault(
            Optional<T> value, T defaultValue) {

        Objects.requireNonNull(value, "Optional cannot be null");
        return value.orElse(defaultValue);
    }

    // 3. Return the larger comparable object
    public static <T extends Comparable<T>> T max(T a, T b) {

        Objects.requireNonNull(a, "First value cannot be null");
        Objects.requireNonNull(b, "Second value cannot be null");

        return a.compareTo(b) >= 0 ? a : b;
    }

    // 4. Check whether an object is null
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class q5 {

    public static void main(String[] args) {

        // isEqual()
        System.out.println(Utility.isEqual("Java", "Java"));
        System.out.println(Utility.isEqual(10, 20));

        // getDefault()
        Optional<String> email =
                Optional.of("student@gmail.com");

        Optional<String> empty = Optional.empty();

        System.out.println(Utility.getDefault(
                email, "default@gmail.com"));

        System.out.println(Utility.getDefault(
                empty, "default@gmail.com"));

        // max()
        System.out.println(Utility.max(10, 25));
        System.out.println(Utility.max("Apple", "Banana"));

        // isNull()
        String name = null;
        String language = "Java";

        System.out.println(Utility.isNull(name));
        System.out.println(Utility.isNull(language));
    }
}
