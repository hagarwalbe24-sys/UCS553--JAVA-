import java.util.Scanner;

public class Third {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            char op = sc.next().charAt(0);

            double result;

            switch (op) {

                case '+':
                    result = a + b;
                    break;

                case '-':
                    result = a - b;
                    break;

                case '*':
                    result = a * b;
                    break;

                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result = a / b;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operator");
            }

            System.out.println("Result = " + result);
        }

        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid numeric input");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }
}