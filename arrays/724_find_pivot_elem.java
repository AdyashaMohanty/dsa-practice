/*
 * Problem: Find Pivot Index (LeetCode #724)
 * Link: https://leetcode.com/problems/find-pivot-index/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach 1 (Brute Force - commented): O(n²) time, O(1) space
 *   - For each index, compute left and right sums separately
 *   - Redundant recomputation at every index
 *
 * Approach 2 (Prefix Sum - OPTIMAL): O(n) time, O(1) space
 *   - Precompute total sum, maintain running left sum
 *   - At each index: right sum = total - leftSum - nums[i]
 *   - If leftSum == rightSum → pivot found
 *   - Example: [1,7,3,6,5,6] → total=28, at i=3: ls=11, rs=11 → return 3
 *
 * Why Prefix Sum beats Brute Force: O(n) vs O(n²), single pass after total sum
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        /*
        // Approach 1: Brute Force
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) left += nums[j];
            for (int j = i + 1; j < n; j++) right += nums[j];
            if (left == right) return i;
        }
        return -1;
        */

        // Approach 2: Prefix Sum (Optimal)
        int sum = 0;
        for(int num:nums) sum += num;

        int rs = sum;
        int ls = 0;
        int val;
        for(int i=0;i<n;i++){
            val = nums[i];
            rs -= val;
            if(rs == ls) return i;
            ls += val;
        }
        return -1;
    }
}
