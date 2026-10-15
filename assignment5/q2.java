
import java.util.Optional;

public class q2 {

    public static void main(String[] args) {

        // 1. Optional containing an email
        Optional<String> email =
                Optional.of("student@gmail.com");

        // 2. Empty Optional
        Optional<String> emptyEmail = Optional.empty();

        // 3. Display email using ifPresent()
        System.out.println("Email:");
        email.ifPresent(System.out::println);

        emptyEmail.ifPresent(
                e -> System.out.println("Email: " + e));

        // 4. Provide a default email using orElse()
        String defaultEmail =
                emptyEmail.orElse("default@gmail.com");

        System.out.println("Default email: " + defaultEmail);

        // 5. Handle missing email using orElseThrow()
        try {
            String requiredEmail = emptyEmail.orElseThrow(
                    () -> new IllegalArgumentException(
                            "Email is missing"));

            System.out.println(requiredEmail);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
