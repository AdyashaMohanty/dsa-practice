/*
 * Problem: Range Sum Query - Immutable (LeetCode #303)
 * Link: https://leetcode.com/problems/range-sum-query-immutable/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach (Prefix Sum - OPTIMAL): O(n) build, O(1) query, O(n) space
 *   - Build prefix array of size n+1 (extra index avoids boundary checks)
 *   - p[i+1] = p[i] + nums[i], so p[0] = 0 always
 *   - sumRange(left, right) = p[right+1] - p[left]
 *   - Example: nums=[1,2,3,4] → p=[0,1,3,6,10]
 *              sumRange(1,3) = p[4] - p[1] = 10 - 1 = 9 ✓
 *
 * Why n+1 size: p[0]=0 acts as base, eliminates left boundary edge case
 */
class NumArray {
    int[] p;
    public NumArray(int[] nums) {
        p = new int[nums.length+1];
        for(int i = 0; i<nums.length; i++){
            p[i+1] = p[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return p[right+1] - p[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
