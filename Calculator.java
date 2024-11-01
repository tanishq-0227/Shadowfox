import java.util.Scanner;
public class Calculator {
        
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Welcome to the Calculator!");
                System.out.println("--------------------------");
                System.out.println("1. Basic Arithmetic Operations");
                System.out.println("2. Scientific Calculations");
                System.out.println("3. Unit Conversions");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        basicArithmetic(scanner);
                        break;
                    case 2:
                        scientificCalculations(scanner);
                        break;
                    case 3:
                        unitConversions(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        }

    private static void basicArithmetic(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.println("Choose operation: +, -, *, /");
        char operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation!");
        }
    }

    private static void scientificCalculations(Scanner scanner) {
        System.out.println("Choose calculation: 1. Square Root 2. Exponentiation");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                double number = scanner.nextDouble();
                if (number >= 0) {
                    System.out.println("Square Root: " + Math.sqrt(number));
                } else {
                    System.out.println("Error: Cannot compute square root of a negative number.");
                }
                break;
            case 2:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    private static void unitConversions(Scanner scanner) {
        System.out.println("Choose conversion: 1. Celsius to Fahrenheit 2. Fahrenheit to Celsius");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9/5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahr = scanner.nextDouble();
                double celsiusResult = (fahr - 32) * 5/9;
                System.out.println("Temperature in Celsius: " + celsiusResult);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
