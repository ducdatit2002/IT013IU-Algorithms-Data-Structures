public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = findSum(arr, arr.length);
        System.out.println("The sum of the elements in the array is: " + sum);
    }

    public static int findSum(int[] a, int n) {
        // Base case: If the array has only one element, return that element.
        if (n == 1) {
            return a[0];
        } else {
            // Recursive case: Sum the last element with the sum of the rest of the array.
            return a[n - 1] + findSum(a, n - 1);
        }
    }
}
