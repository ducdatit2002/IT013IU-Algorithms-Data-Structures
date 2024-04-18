import java.util.Scanner;

public class min_Gap {
    public static int minGap(int[] array, int numElements) {
        if (numElements < 2) {
            return 0; // Return 0 if array has fewer than 2 elements
        }

        int minGap = Integer.MAX_VALUE;

        for (int i = 0; i < numElements - 1; i++) {
            int gap = array[i + 1] - array[i];
            if (gap < minGap) {
                minGap = gap;
            }
        }

        return minGap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numElements = scanner.nextInt();

        int[] array = new int[numElements];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < numElements; i++) {
            array[i] = scanner.nextInt();
        }

        int result = minGap(array, numElements);
        System.out.println("Minimum gap: " + result);

        scanner.close();
    }
}