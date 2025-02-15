// TC - O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Tried 2D Dp Solution then optimised it to 1D

public class PartitionArray {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                // curr = partition value + value of remaining subproblem
                int curr = max * j;
                if (i - j >= 0)
                    curr = max * j + dp[i - j];
                dp[i] = Math.max(dp[i], curr);
            }
        }
        return dp[n - 1];
    }
}
