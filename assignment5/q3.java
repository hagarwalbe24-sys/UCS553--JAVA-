
import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {

    private final T marks;
    private final double maximumMarks;
    private final double passThreshold;

    Result(T marks, double maximumMarks, double passThreshold) {

        this.marks = Objects.requireNonNull(
                marks, "Marks cannot be null");

        if (maximumMarks <= 0) {
            throw new IllegalArgumentException(
                    "Maximum marks must be positive");
        }

        if (passThreshold < 0 || passThreshold > 100) {
            throw new IllegalArgumentException(
                    "Threshold must be between 0 and 100");
        }

        double numericMarks = marks.doubleValue();

        if (numericMarks < 0 || numericMarks > maximumMarks) {
            throw new IllegalArgumentException(
                    "Marks are outside the valid range");
        }

        this.maximumMarks = maximumMarks;
        this.passThreshold = passThreshold;
    }

    double getPercentage() {
        return (marks.doubleValue() / maximumMarks) * 100;
    }

    double getAverage() {
        return marks.doubleValue();
    }

    boolean hasPassed() {
        return getPercentage() >= passThreshold;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class q3 {

    public static void main(String[] args) {

        Result<Integer> student1 = new Result<>(85, 100, 40);
        Result<Double> student2 = new Result<>(32.5, 50, 40);

        displayResult("Student 1", student1);
        displayResult("Student 2", student2);
    }

    static <T extends Number> void displayResult(
            String name, Result<T> result) {

        System.out.println("\n" + name);

        result.getMarks().ifPresent(marks -> {
            System.out.println("Marks: " + marks);
            System.out.printf("Percentage: %.2f%%%n",
                    result.getPercentage());
            System.out.println("Numeric marks: "
                    + result.getAverage());
            System.out.println("Result: "
                    + (result.hasPassed() ? "PASS" : "FAIL"));
        });
    }
}
