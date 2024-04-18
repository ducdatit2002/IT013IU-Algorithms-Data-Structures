public class minGap {
    public static int minGap1(int[] array, int numElements) {
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
        int[] array = {1, 3, 6, 7, 12};
        int numElements = array.length;
        int result = minGap(array, numElements);
        System.out.println("Minimum gap: " + result);
    }
}