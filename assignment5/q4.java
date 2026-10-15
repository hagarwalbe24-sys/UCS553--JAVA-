
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class q4 {

    public static void main(String[] args) {

        String eventName = "Java Workshop";
        LocalDate eventDate = LocalDate.now().plusDays(5);
        LocalTime startTime = LocalTime.of(10, 30);

        // Optional venue
        Optional<String> venue =
                Optional.of("Main Auditorium");

        // To test an absent venue, use:
        // Optional<String> venue = Optional.empty();

        LocalTime endTime = startTime.plusHours(2);

        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);

        System.out.println("Venue: "
                + venue.orElse("Venue not specified"));

        LocalDate today = LocalDate.now();

        if (eventDate.isAfter(today)) {
            System.out.println("Status: Future event");
        } else if (eventDate.isEqual(today)) {
            System.out.println("Status: Event is today");
        } else {
            System.out.println("Status: Event is in the past");
        }

        long daysRemaining =
                ChronoUnit.DAYS.between(today, eventDate);

        if (daysRemaining > 0) {
            System.out.println("Days remaining: "
                    + daysRemaining);
        } else if (daysRemaining == 0) {
            System.out.println("Event is today!");
        } else {
            System.out.println("Event passed "
                    + Math.abs(daysRemaining) + " days ago.");
        }
    }
}
