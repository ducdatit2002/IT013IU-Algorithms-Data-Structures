import java.util.Scanner;

public class convertArray {
    public static int convertArrayToNumber(int[] digits) {
        int number = 0;
        int power = digits.length - 1;

        for (int digit : digits) {
            number += digit * Math.pow(10, power);
            power--;
        }

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of digits: ");
        int numDigits = scanner.nextInt();

        int[] digits = new int[numDigits];

        System.out.println("Enter the digits:");
        for (int i = 0; i < numDigits; i++) {
            digits[i] = scanner.nextInt();
        }

        int result = convertArrayToNumber(digits);
        System.out.println("Converted number: " + result);

        scanner.close();
    }
}