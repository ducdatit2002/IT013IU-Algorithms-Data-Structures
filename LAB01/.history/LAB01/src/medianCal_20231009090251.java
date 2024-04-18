import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MedianCalculator {
    public static double calculateMedian(List<Integer> numbers) {
        // Sort the list in ascending order
        Collections.sort(numbers);

        int size = numbers.size();
        if (size % 2 == 0) {
            // If the list size is even, return the average of the middle two numbers
            int middleIndex = size / 2;
            int num1 = numbers.get(middleIndex - 1);
            int num2 = numbers.get(middleIndex);
            return (num1 + num2) / 2.0;
        } else {
            // If the list size is odd, return the middle number
            int middleIndex = size / 2;
            return numbers.get(middleIndex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers (separated by spaces):");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);
            numbers.add(number);
        }

        double median = calculateMedian(numbers);
        System.out.println("Median: " + median);

        scanner.close();
    }
}