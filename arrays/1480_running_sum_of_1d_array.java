/*
 * Problem: Running Sum of 1d Array (LeetCode #1480)
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach 1 (ArrayList - commented): O(n) time, O(n) space
 *   - Accumulate sum into ArrayList, then convert to int[]
 *   - Extra space for ArrayList + conversion overhead
 *
 * Approach 2 (Prefix Array - OPTIMAL): O(n) time, O(n) space
 *   - Directly build result array, sum[i] = sum[i-1] + nums[i]
 *   - No extra data structure, cleaner and more direct
 *   - Example: [1,2,3,4] → sum[0]=1, sum[1]=3, sum[2]=6, sum[3]=10
 *
 * Why Prefix Array beats ArrayList: no type conversion, no boxing overhead
 */
class Solution {
    public int[] runningSum(int[] nums) {
        /*
        // Approach 1: ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;
        for(int num:nums){
            sum+=num;
            res.add(sum);
        }
        int[] res1 = new int[res.size()];
        for(int i=0;i<res.size();i++){
            res1[i] = res.get(i);
        }
        return res1;
        */

        // Approach 2: Prefix Array (Optimal)
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        return sum;
    }
}
