public class Problem03 {
    public static void main(String[] args) {
        int n = 5;
        int result = sum(n);
        System.out.println("The sum of numbers from 1 to " + n + " is: " + result);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1; // Base case: The sum of 1 is 1.
        } else {
            return n + sum(n - 1); // Recursive case: Add n to the sum of the first (n-1) numbers.
        }
    }
}
