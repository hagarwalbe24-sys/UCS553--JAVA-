package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = {
            new Book(101, "Clean Code", "Robert C. Martin"),
            new Book(102, "Effective Java", "Joshua Bloch"),
            new Book(103, "Database System Concepts", "Abraham Silberschatz"),
            new DigitalResource(201, "Java Programming Course", "Oracle"),
            new DigitalResource(202, "Research Journal Archive", "University Library")
        };

        int[] overdueDays = {4, 0, 7, 3, 5};
        double totalFine = 0.0;

        System.out.println("==========================================");
        System.out.println(" SMART LIBRARY RESOURCE MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        for (int i = 0; i < resources.length; i++) {
            LibraryResource resource = resources[i];

            if (!InputValidator.isValidResourceId(resource.getResourceId())) {
                System.out.println("Invalid Resource ID.");
                continue;
            }

            if (!InputValidator.isValidFineDays(overdueDays[i])) {
                System.out.println("Invalid overdue days.");
                continue;
            }

            ((Printable) resource).printDetails();
            double fine = resource.calculateFine(overdueDays[i]);
            System.out.println("Overdue Days: " + overdueDays[i]);
            System.out.println("Calculated Fine: Rs. " + fine);
            System.out.println();
            totalFine += fine;
        }

        System.out.println("==========================================");
        System.out.println("Total Fine of All Resources: Rs. " + totalFine);
        System.out.println("==========================================");
        LibraryResource.displayTotalResources();
    }
}
