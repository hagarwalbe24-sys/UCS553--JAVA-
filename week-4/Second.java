public class Second {
    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {
                int a = 10 / 0;
            }
            catch (ArithmeticException e) {
                System.out.println("Inner catch: Division by zero");
            }

            int[] arr = {10, 20};
            System.out.println(arr[5]);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Invalid array index");
        }

        System.out.println("Program continues...");
    }
}