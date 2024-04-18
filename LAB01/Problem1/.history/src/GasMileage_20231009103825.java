import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of cars: ");
        int numCars = scan.nextInt();

        scan.nextLine(); // Consume the newline character

        for (int i = 1; i <= numCars; i++) {
            System.out.println("Car " + i);

            System.out.print("Enter the miles and gallons (separated by a space): ");
            double miles = scan.nextDouble();
            double gallons = scan.nextDouble();

            double mpg = miles / gallons;

            System.out.println("Miles Per Gallon: " + mpg);
            System.out.println();
            scan.nextLine(); // Consume the newline character
        }

        scan.close();
    }
}