import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------- Hello, Welcome to the Calculator -------");

        int choice;
        int count = 0;

        do {
            if (count > 0) {
                System.out.println("\n✅ Operation completed successfully!");
                System.out.println("Let's start again...\n");
            }

            System.out.print("Enter your first number: ");
            double num1 = getValidNumber(sc);

            System.out.print("Enter your second number: ");
            double num2 = getValidNumber(sc);

            System.out.println("\nChoose your operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Result = " + add(num1, num2));
                case 2 -> System.out.println("Result = " + subtract(num1, num2));
                case 3 -> System.out.println("Result = " + multiply(num1, num2));
                case 4 -> {
                    if (num2 == 0) {
                        System.out.println("⚠️ Cannot divide by zero!");
                    } else {
                        System.out.println("Result = " + divide(num1, num2));
                    }
                }
                case 5 -> System.out.println("\n👋 Exiting program... Thank you!");
                default -> System.out.println("❌ Invalid choice, please try again.");
            }

            count++;
        } while (choice != 5);

        sc.close();
    }

    // --- Operation methods ---
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    // --- Helper method to validate numeric input ---
    public static double getValidNumber(Scanner sc) {
        while (true) {
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.print("❌ Invalid number, please enter again: ");
                sc.next(); // clear invalid input
            }
        }
    }
}
