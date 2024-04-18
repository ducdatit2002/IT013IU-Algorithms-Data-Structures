import java.util.ArrayList;
import java.util.List;

public class Problem08 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);
        System.out.println("All subsets of the given set:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsetsHelper(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {

        result.add(new ArrayList<>(currentSubset));

        // Generate subsets by including and excluding the current element.
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset.
            currentSubset.add(nums[i]);

            // Recursively generate subsets starting from the next index.
            generateSubsetsHelper(nums, i + 1, currentSubset, result);

            // Exclude the current element to backtrack and generate other subsets.
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
