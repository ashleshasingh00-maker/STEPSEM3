import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixCounts.containsKey(currentSum - k)) {
                count += prefixCounts.get(currentSum - k);
            }

            prefixCounts.put(
                currentSum,
                prefixCounts.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }
}
